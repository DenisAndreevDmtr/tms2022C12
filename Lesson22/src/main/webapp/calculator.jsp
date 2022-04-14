<html>
<head>
    <title> Calculator form</title>
</head>
<body>
<form method="post" , action="calculator">
    Number1:<input type="number" name="number1"/></br>
    Number2:<input type="number" name="number2"/></br>
    Operation: <select name="operator">
    <option>+</option>
    <option>-</option>
    <option>*</option>
    <option>/</option>
</select>
    <input type="submit" name="calculate" value="calculate"></br>
    <input type="reset" value="reset"><br>
    LastOperation:${operation}<br>
    LastResult:${result}
</form>
</body>
</html>