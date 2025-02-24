
<?php
    require "dbCon.php";
    $student_id = $_POST['student_id'];
    $query = "SELECT * FROM student_schedule WHERE student_id = '$student_id' ";

	$data = mysqli_query($connect, $query);

    //Tao lớp 
    class Schedule{
		function __construct($s_id,  $s_name,  $s_tstart,  $s_tend, $s_daybegin,  $s_dayend,
        $student_id,  $s_location,  $teacher_id){
			$this->s_id = $s_id;
			$this->s_name  =$s_name;
			$this->s_tstart = $s_tstart;
			$this->s_tend = $s_tend;
            $this->s_daybegin = $s_daybegin;
			$this->s_dayend = $s_dayend;
            $this->student_id = $student_id;
            $this->s_location = $s_location;
            $this->teacher_id = $teacher_id;
		}
	}
    //2.Tao mang 
    $mangSchedule = array();
    //3. Them phan tu vao mang
    while($row = mysqli_fetch_assoc($data)){
       array_push($mangSchedule, new Schedule($row['s_id'],$row['s_name'],$row['s_tstart'],$row['s_tend'],$row['s_daybegin'],$row['s_dayend'],$row['student_id'],$row['s_location'],$row['teacher_id']));
    }

    //4.Chuyen dinh dang cua mang -->Json
    echo json_encode($mangSchedule);

?>
