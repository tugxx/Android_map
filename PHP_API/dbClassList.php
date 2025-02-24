<?php
	require "dbCon.php";
	$student_id = $_POST['student_id'];
    $query = "SELECT * from class c INNER join student_class sc on c.class_id = sc.class_id WHERE student_id='$student_id'";

	$data = mysqli_query($connect, $query);

    //Tao lớp 
    class classS{
		function __construct($class_id, $class_name){
			$this->id = $class_id;
			$this->name = $class_name;

		}
	}
    //2.Tao mang 
    $mangSV = array();
    //3. Them phan tu vao mang
    while($row = mysqli_fetch_assoc($data)){
       array_push($mangSV, new classS($row['class_id'],$row['class_name']));
    }

    //4.Chuyen dinh dang cua mang -->Json
    if(!empty($mangSV)) echo json_encode($mangSV);
    else echo ("Error");
//
?>