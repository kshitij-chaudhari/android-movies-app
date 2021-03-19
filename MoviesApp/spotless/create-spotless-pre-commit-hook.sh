# Run this script to create a pre-commit hook for Spotless.
# Note that this script currently override any existing pre-commit file
mkdir -p ../.git/hooks
echo "#!/bin/bash
echo \"Running spotless check\"
cd MoviesApp
./gradlew spotlessApply
cd ..
" >../.git/hooks/pre-commit

chmod 777 ../.git/hooks/pre-commit
