<?php
	require "Constants.php";

	// $connect = mysqli_connect("localhost","id16968273_root","NvACgZ9d?&XN}4w|","id16968273_student_attendance");
	$connect = mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME);

	mysqli_query($connect, "SET NAMES utf8");

	class dbuser{
		function __construct($id, $username, $password, $oldpass,$i_student, $i_teacher,$i_role,$status) {
			$this->id = $id;
			$this->username  =$username;
			$this->password = $password;
			$this->oldpass = $oldpass;
			$this->i_student = $i_student;
			$this->i_teacher = $i_teacher;
			$this->i_role = $i_role;
			$this->status = $status;
		}	
	}
	
	class dbclass{
		function __construct($class_id, $class_name, $teacher_id, $class_time, $totalstudent) {
			$this-> class_id = $class_id;
			$this-> class_name  =$class_name;
			$this-> teacher_id = $teacher_id;
			$this-> class_time = $class_time;
			$this-> totalstudent = $totalstudent;			
		}	
	}
	
	class inforstudent{
		function __construct($student_id, $student_name, $student_birth,$student_gender,$student_mail,$student_phone,$student_image, $status)
		{
			$this->student_id = $student_id;
			$this->student_name = $student_name;
			$this->student_birth = $student_birth;
			$this->student_gender = $student_gender;
			$this->student_mail = $student_mail;
			$this->student_phone = $student_phone;
			$this->student_image = $student_image;
			$this->status = $status;
		}
	}

	class dbclass_present{
		function __construct($class_id, $class_name){
			$this-> class_id = $class_id;
			$this-> class_name  =$class_name;
		}
	}

	class dbtime_present_student{
		function __construct($attendance_time){
			$this-> attendance_time = $attendance_time;
		}
	}	

	class usercheck{
		function __construct($username, $student_phone)
		{
			$this->username = $username;
			$this->student_phone = $student_phone;
		}
	}

	class inforteacher{
		function __construct($teacher_id, $teacher_name, $teacher_birth,$teacher_gender,$teacher_mail,$teacher_phone,$teacher_image, $status)
		{
			$this->teacher_id = $teacher_id;
			$this->teacher_name = $teacher_name;
			$this->teacher_birth = $teacher_birth;
			$this->teacher_gender = $teacher_gender;
			$this->teacher_mail = $teacher_mail;
			$this->teacher_phone = $teacher_phone;
			$this->teacher_image = $teacher_image;
			$this->status = $status;
		}
	}

	class dbtime_present_teacher{
		function __construct($student_id, $student_name, $attendance_time)
		{
			$this->student_id = $student_id;
			$this->student_name = $student_name;
			$this->attendance_time = $attendance_time;
		}
	}

	class dbtime_absent_teacher{
		public $student_id;
		
		function __construct($student_id, $student_name, $attendance_time) {
			$this->student_id = $student_id;
			$this->student_name = $student_name;
			$this->attendance_time = $attendance_time;
		}
		
		public function getStudentid() {
    		return $this->student_id;
  		}
	}

	class dbstudent_absent{
		public $student_id;
		function __construct($student_id, $student_name) {
			$this->student_id = $student_id;
			$this->student_name = $student_name;
		}

		public function getStudentid() {
    		return $this->student_id;
  		}
	}

	class Schedule {
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

	class Student{
		function __construct($student_id, $student_name, $student_birth,$student_gender,$student_mail,$student_phone,$student_image,$status){
			$this->id = $student_id;
			$this->fname  =$student_name;
			$this->birth = $student_birth;
			$this->gender = $student_gender;
            $this->mail = $student_mail;
			$this->phone = $student_phone;
            $this->image = $student_image;
            $this->status = $status;
		}
	}
?>
