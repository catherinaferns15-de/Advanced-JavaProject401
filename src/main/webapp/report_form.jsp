<!DOCTYPE html>
<html>
<head>
<title>Reports</title>
 <link rel="stylesheet" href="style.css">

<script>
function showFields() {
    var type = document.getElementById("type").value;

    // Hide all first
    document.getElementById("priceDiv").style.display = "none";
    document.getElementById("categoryDiv").style.display = "none";
    document.getElementById("topDiv").style.display = "none";

    // Show based on selection
    if (type === "price") {
        document.getElementById("priceDiv").style.display = "block";
    } 
    else if (type === "category") {
        document.getElementById("categoryDiv").style.display = "block";
    } 
    else if (type === "top") {
        document.getElementById("topDiv").style.display = "block";
    }
}
</script>

</head>

<body>

<a href="index.jsp"> Home</a>
<hr>

<h2>Generate Report</h2>

<form action="report" method="post">

    <label>Select Report Type:</label>
    <select name="type" id="type" onchange="showFields()">
        <option value="">--Select--</option>
        <option value="price">Price Greater Than</option>
        <option value="category">Category</option>
        <option value="top">Top N Products</option>
    </select>

    <br><br>

    <!-- Price Field -->
    <div id="priceDiv" style="display:none;">
        Enter Price: <input type="text" name="price">
    </div>

    <!-- Category Field -->
    <div id="categoryDiv" style="display:none;">
        Enter Category: <input type="text" name="category">
    </div>

    <!-- Top N Field -->
    <div id="topDiv" style="display:none;">
        Enter N Value: <input type="text" name="n">
    </div>

    <br>
    <input type="submit" value="Generate Report">

</form>

</body>
</html>