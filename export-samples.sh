#!/bin/bash
./build-magicbrush.sh
./generate-samples.sh
zip -r --filesync \
    ../magicbrush-samples-MinXu-$(date +"%Y-%m-%d-%H-%M").zip samples/
