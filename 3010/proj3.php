<html>
<body>
<?php
		$totalPrice = ($_POST['numWids1']*12.45) + ($_POST['numWids2']*15.34) + ($_POST['numWids3']*28.99);
    	$totalQuantity = ($_POST['numWids1'] + $_POST['numWids2'] + $_POST['numWids3']);
    	$shipping = 8.74;
    	$tax;
    	$discount;

    	if($totalQuantity > "30"){
        $shipping = 15.35;
    	}
		if($totalQuantity > "50"){
			$discount = $totalPrice * 0.05;
			$totalPrice = $totalPrice - $discount;
		}

		if($_POST['STATE'] == "KS"){
			$tax = 0.04375 * ($totalPrice +$shipping)
		}
		if($_POST['STATE'] == "FL"){
			$tax = 0.06265 * $totalPrice;
			$totalPrice = $totalPrice + $shipping;
		}
		if($_POST)['STATE'] == "Other"){
			$tax = 0;
		}
		
		echo "Model: 37AX-L</br>";		
		echo "Number of Widgets: " .$_POST['numWids1']."</br>";
		echo "Amount: $".$price1."</br>";
		echo"</br></br>";
		
		echo "Model: 42XR-J</br>";		
		echo "Number of Widgets: " .$_POST['numWids2']."</br>";
		echo "Amount: $".$price2."</br>";
		echo"</br></br>";
		
		echo "Model: 93ZZ-A</br>";		
		echo "Number of Widgets: " .$_POST['numWids3']."</br>";
		echo "Amount: $".$price3."</br>";
		echo"</br></br>";
		
		echo "Total Price: $".$totalPrice
		echo "Discount: $" .$discount"</br>";
		echo "Sales Tax: $" .$total_tax."</br>";
		echo "</br></br>";

?>
</body>
</html>