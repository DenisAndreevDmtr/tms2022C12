<html>
<head>
    <title> Calculator form</title>
</head>
<body>
<form method="post" , action="calculator">
    Number1:<input type="number" name="number1"/></br>
    Number2:<input type="number" name="number2"/></br>
    <input type="submit" name="sum" value="+">
    <input type="submit" name="difference" value="-">
    <input type="submit" name="multiply" value="*">
    <input type="submit" name="divide" value="/">
    <input type="reset" value="reset"><br>
    LastOperation:${operation}<br>
    LastResult:${result}
</form>
</body>
</html>