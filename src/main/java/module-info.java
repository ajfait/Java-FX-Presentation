module org.openjfx.javafxpresentation {
    // JavaFX core modules
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    // Third-party libraries
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    // JPA / Hibernate
    requires java.naming;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;

    // Exports - only what's needed publicly
    exports org.openjfx.javafxpresentation.entity;
    exports org.openjfx.javafxpresentation.controller;
    exports org.openjfx.javafxpresentation.view;

    // Opens - required for reflection (FXML, Hibernate)
    opens org.openjfx.javafxpresentation.entity to javafx.fxml, org.hibernate.orm.core;
    opens org.openjfx.javafxpresentation.controller to javafx.fxml;
    opens org.openjfx.javafxpresentation.view to javafx.fxml;
}