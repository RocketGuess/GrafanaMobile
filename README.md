# GrafanaMobile
Android app for https://grafana.com/

## For developers

Requirements: android sdk https://developer.android.com/studio/index.html#command-tools

We use gradle for build, lint & deploy

### Show all gradle tasks

    ./gradlew tasks

### Deploy to target device

    ./gradlew installDebug

P.S. for show list of current attached devices use

    adb devices

### Run linter

    ./gradlew lint
    open app/build/reports/lint-results.html
