import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;

/**
 * CRUD application: JavaFX UI + JDBC (MySQL).
 *
 * Database setup (run once in MySQL):
 *   CREATE DATABASE oopslab;
 *   USE oopslab;
 *   CREATE TABLE student (id INT PRIMARY KEY, name VARCHAR(50), dept VARCHAR(30), marks INT);
 *
 * Update URL / USER / PASS below to match your MySQL setup.
 */
public class Main extends Application {

    static final String URL  = "jdbc:mysql://localhost:3306/oopslab";
    static final String USER = "root";
    static final String PASS = "root";

    static class Student {
        int id; String name; String dept; int marks;
        Student(int id, String name, String dept, int marks) {
            this.id = id; this.name = name; this.dept = dept; this.marks = marks;
        }
        public int getId() { return id; }
        public String getName() { return name; }
        public String getDept() { return dept; }
        public int getMarks() { return marks; }
    }

    TextField tfId = new TextField(), tfName = new TextField(), tfDept = new TextField(), tfMarks = new TextField();
    TableView<Student> table = new TableView<>();
    ObservableList<Student> data = FXCollections.observableArrayList();

    Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    @Override
    public void start(Stage stage) {
        tfId.setPromptText("ID");
        tfName.setPromptText("Name");
        tfDept.setPromptText("Department");
        tfMarks.setPromptText("Marks");

        TableColumn<Student, Integer> cId = new TableColumn<>("ID");
        cId.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("id"));
        TableColumn<Student, String> cName = new TableColumn<>("Name");
        cName.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("name"));
        TableColumn<Student, String> cDept = new TableColumn<>("Dept");
        cDept.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("dept"));
        TableColumn<Student, Integer> cMarks = new TableColumn<>("Marks");
        cMarks.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("marks"));
        table.getColumns().addAll(cId, cName, cDept, cMarks);
        table.setItems(data);

        table.getSelectionModel().selectedItemProperty().addListener((o, old, s) -> {
            if (s != null) {
                tfId.setText(String.valueOf(s.id));
                tfName.setText(s.name);
                tfDept.setText(s.dept);
                tfMarks.setText(String.valueOf(s.marks));
            }
        });

        Button add = new Button("Create"), upd = new Button("Update"),
               del = new Button("Delete"), clr = new Button("Clear");
        add.setOnAction(e -> insert());
        upd.setOnAction(e -> update());
        del.setOnAction(e -> delete());
        clr.setOnAction(e -> clearFields());

        HBox form = new HBox(10, tfId, tfName, tfDept, tfMarks);
        HBox buttons = new HBox(10, add, upd, del, clr);
        VBox root = new VBox(10, form, buttons, table);
        root.setPadding(new Insets(15));

        loadData();
        stage.setTitle("Student CRUD - JavaFX + JDBC");
        stage.setScene(new Scene(root, 650, 450));
        stage.show();
    }

    void loadData() {
        data.clear();
        try (Connection c = connect();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM student")) {
            while (rs.next())
                data.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        } catch (SQLException e) { alert(e.getMessage()); }
    }

    void insert() {
        try (Connection c = connect();
             PreparedStatement ps = c.prepareStatement("INSERT INTO student VALUES (?,?,?,?)")) {
            ps.setInt(1, Integer.parseInt(tfId.getText()));
            ps.setString(2, tfName.getText());
            ps.setString(3, tfDept.getText());
            ps.setInt(4, Integer.parseInt(tfMarks.getText()));
            ps.executeUpdate();
            loadData(); clearFields();
        } catch (Exception e) { alert(e.getMessage()); }
    }

    void update() {
        try (Connection c = connect();
             PreparedStatement ps = c.prepareStatement("UPDATE student SET name=?, dept=?, marks=? WHERE id=?")) {
            ps.setString(1, tfName.getText());
            ps.setString(2, tfDept.getText());
            ps.setInt(3, Integer.parseInt(tfMarks.getText()));
            ps.setInt(4, Integer.parseInt(tfId.getText()));
            ps.executeUpdate();
            loadData(); clearFields();
        } catch (Exception e) { alert(e.getMessage()); }
    }

    void delete() {
        try (Connection c = connect();
             PreparedStatement ps = c.prepareStatement("DELETE FROM student WHERE id=?")) {
            ps.setInt(1, Integer.parseInt(tfId.getText()));
            ps.executeUpdate();
            loadData(); clearFields();
        } catch (Exception e) { alert(e.getMessage()); }
    }

    void clearFields() { tfId.clear(); tfName.clear(); tfDept.clear(); tfMarks.clear(); }

    void alert(String msg) { new Alert(Alert.AlertType.ERROR, msg).showAndWait(); }

    public static void main(String[] args) { launch(args); }
}
