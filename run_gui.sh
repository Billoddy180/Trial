#!/bin/bash

# Script to run the JavaFX GUI application
echo "Starting Library Management System GUI..."
java --module-path /usr/share/openjfx/lib --add-modules javafx.controls,javafx.fxml LMS_UI
