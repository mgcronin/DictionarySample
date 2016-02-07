# DictionarySample


# Introduction
This is a sample Java application that makes use of a Trie datastrucutre to lookup a user provided word against a dictionary. If a word is not found a suggestion will be made.

For simplicity sake the sample will use case sensitivity.  For real world depending on requirements we would  want to ensure the dictionary is stored to the trie in lower case.  We would then use a case insensitive search when doing a word lookup.  That is beyond the scope of this sample

A Trie datastructure was choosen for its effeciency in solving this problem.  Insert and search costs O(key_length). Space requirement should be O(N*C) where C is the average number of characters per word and N is the number of words.

For more information on the [Trie datastructure](https://en.wikipedia.org/wiki/Trie)

# Running
mvn clean package

java -cp target/sample-app-1.0-SNAPSHOT-jar-with-dependencies.jar com.cronin.app.WordLookupApp

# Sample Output

Enter a word for dictionary lookup (valid charachters [a-z A-Z]): eastz

input: eastz was not found

Possible suggestion of: east

Enter a word for dictionary lookup (valid charachters [a-z A-Z]): incorrigible

input: incorrigible was found in the dictionary
