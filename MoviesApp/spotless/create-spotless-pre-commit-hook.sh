# Run this script to create a pre-commit hook for Spotless.
# Note that this script currently override any existing pre-commit file
mkdir -p ../.git/hooks
echo "#!/bin/bash
echo \"Running spotless check\"
./MoviesApp/gradlew spotlessApply --daemon
status=$?
[ $status -ne 0 ] && exit 1
exit 0
" >../.git/hooks/pre-commit

chmod 755 ../.git/hooks/pre-commit
