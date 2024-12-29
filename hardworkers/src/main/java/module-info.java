module hardworkers{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;

    opens id.ac.ukdw.fti.rpl.hardworkers to javafx.fxml;
    exports id.ac.ukdw.fti.rpl.hardworkers;
    exports id.ac.ukdw.fti.rpl.hardworkers.database;
    exports id.ac.ukdw.fti.rpl.hardworkers.modal;
}
