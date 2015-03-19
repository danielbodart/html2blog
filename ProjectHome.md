A simple command line tool that takes HTML and creates a draft post on a Blog.

The html2blog.jar is a [OneJar](http://one-jar.sourceforge.net/) release and so it bundles all libraries in the jar (so the reason it's 3mb is that it contains the Scala runtime)

Usage:
html2blog currently looks for a properties file in the current working directory that contains the following:

```
user=blogusername
password=passowrd
url=http\://your.domain.name/xmlrpc.php
```
Note the escaped ":" in the url

It currently takes the input from the console so it can be piped together like:

```
stx2any --link-abbrevs --make-title off -T html $1 | tidy -asxhtml -qc -w 0 | java -jar html2blog.jar
```
