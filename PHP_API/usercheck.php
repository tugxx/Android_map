// checks if a username exists in the database and, if so, retrieves user information and returns it as a JSON object

<?php
	require "dbCon.php";

	//  checks if the username value has been submitted
	if(isset($_POST['username']))
	{
		$username= $_POST['username'];
		$query = "SELECT * FROM users JOIN student ON users.id = student.student_id WHERE users.username = '$username'";
		$data = mysqli_query($connect, $query);		

		$usercheck = null;
		while ($row = mysqli_fetch_assoc($data)) 
        {
			$usercheck = new usercheck($row['username'], $row['student_phone']);
        }

        if ($usercheck === null) {
        	error_log("Usercheck null");
        }

		if ($usercheck !== null) {
			echo json_encode($usercheck);   
		} else {
			echo "Error";
		};
	} else {
		echo "Error: No username provided";
	}
?>