# unfinished
echo "installing software dependencies into environment"
yum install git -y
yum install java -y
yum install gradle -y

git pull access token
cd sortingAlgorithms

touch build_log
build_log < running gradle build........\n
build_log << gradle build
build_log << running jacoco test talk.......\n
build log << gradle jacocoTest

buildTime = `date +%d%m%y`
mkdir $buildTime
cd $buildTime

echo "copying pmd report"
cp ./buildTime ../build/reports/pmd
echo "copying jacoco report"
cp ./buildTime ../build/reports/jacoco
echo "copying junit report"
cp ./buildTime ../build/reports/tests

cd ..
zip -r $buildTime.zip ./$buildTime

# send off zip to slack channel
curl slack token api

make sure you ignore this script file and any tokens with
your .gitignore file
