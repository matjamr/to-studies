package com.to.studies.sicknesssimulator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;

public class UiPanelController {
    @FXML
    public ToggleButton startStopButton;

    @FXML
    public Button saveButton;

    @FXML
    public Button dumpButton;

    @FXML
    public Label infectedLabel;

    @FXML
    public Label healthyLabel;

    @FXML
    public Pane drawablePane;


}
