#!/bin/bash
# Android SDK installer script (non-root, latest)

# Set working directories
SDK_DIR="$HOME/Android/Sdk"
CMDLINE_DIR="$SDK_DIR/cmdline-tools/latest"

# Create directories
mkdir -p "$CMDLINE_DIR"

# Download command line tools (latest)
cd /tmp || exit
wget https://dl.google.com/android/repository/commandlinetools-linux-13114758_latest.zip -O commandlinetools.zip

# Unzip to proper location
unzip -q commandlinetools.zip -d "$CMDLINE_DIR"
rm commandlinetools.zip

# Set environment variables
echo "export ANDROID_SDK_ROOT=$SDK_DIR" >> "$HOME/.bashrc"
echo "export PATH=\$PATH:$CMDLINE_DIR/bin" >> "$HOME/.bashrc"
source "$HOME/.bashrc"

# Accept licenses
yes | "$CMDLINE_DIR/bin/sdkmanager" --licenses

# Install essential SDK packages
"$CMDLINE_DIR/bin/sdkmanager" "platform-tools" "platforms;android-33" "build-tools;33.0.2"

echo "Android SDK setup completed!"