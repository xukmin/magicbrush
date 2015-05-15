#!/bin/bash
./clean-magicbrush.sh

git archive \
    --format=zip \
    --prefix=magicbrush/ \
    --output=../magicbrush-source-MinXu-$(date +"%Y-%m-%d-%H-%M").zip HEAD .
