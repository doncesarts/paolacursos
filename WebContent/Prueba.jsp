<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/pdfobject.js"></script>

<style>

/*
PDFObject appends the classname "pdfobject-container" to the target element.
This enables you to style the element differently depending on whether the embed was successful.
*/
#example1{
	width: 100%;
	max-width: 600px;
	height: 600px;
	margin: 2em 0;
}

/* PDFObject automatically assigns the class name "pdfobject" to the <embed> element */
.pdfobject { border: solid 1px #666; }

</style>

</head>
<body>
<div id="example1" ></div>
</body>

<script>PDFObject.embed("Apuntes JavaScript.pdf", "#example1");</script>
</html>