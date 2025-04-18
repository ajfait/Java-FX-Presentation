module org.openjfx.javafxpresentation {
    requires java.naming;

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    opens org.openjfx.javafxpresentation to javafx.fxml;

    exports org.openjfx.javafxpresentation;
    exports org.openjfx.javafxpresentation.entity;

    opens org.openjfx.javafxpresentation.entity to javafx.fxml, org.hibernate.orm.core;
}
