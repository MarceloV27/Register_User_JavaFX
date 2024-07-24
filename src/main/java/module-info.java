module com.example.register_user_javafx {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;


    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.register_user_javafx to javafx.fxml , javafx.controls;
    exports com.example.register_user_javafx;
}