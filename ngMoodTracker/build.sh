#!/bin/sh
ng build --base-href=/MoodTracker/
cp -rp dist/ng-mood-tracker/* ~/SD/Java/EventTracker/MoodTracker/src/main/resources/static
