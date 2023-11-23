module com.to.studies.sicknesssimulator {
    requires javafx.controls;
    requires javafx.fxml;

        requires org.controlsfx.controls;
                        requires org.kordamp.bootstrapfx.core;
                requires com.almasb.fxgl.all;
    requires lombok;

    opens com.to.studies.sicknesssimulator to javafx.fxml;
    exports com.to.studies.sicknesssimulator;
    exports com.to.studies.sicknesssimulator.controller;
    opens com.to.studies.sicknesssimulator.controller to javafx.fxml;
}
