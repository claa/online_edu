<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>后台管理系统</title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<!-- basic styles -->

		<link href="../../css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="../../css/font-awesome.min.css" />

		<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

		<!-- page specific plugin styles -->
		
		<!-- fonts -->

		<link rel="stylesheet" href="../../css/cyrillic.css" />

		<!-- ace styles -->

		<link rel="stylesheet" href="../../css/ace.min.css" />
		<link rel="stylesheet" href="../../css/ace-rtl.min.css" />
		<link rel="stylesheet" href="../../css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- inline styles related to this page -->

		<!-- ace settings handler -->

		<script src="../../js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lt IE 9]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
		
	</head>
	<body>
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							后台管理系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src=""/>
								<span class="user-info">
									<small>Welcome,</small>
									${sessionScope.name}
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="icon-cog"></i>
										Settings
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-user"></i>
										Profile
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="#">
										<i class="icon-off"></i>
										Logout
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<button class="btn btn-success">
								<i class="icon-signal"></i>
							</button>

							<button class="btn btn-info">
								<i class="icon-pencil"></i>
							</button>

							<button class="btn btn-warning">
								<i class="icon-group"></i>
							</button>

							<button class="btn btn-danger">
								<i class="icon-cogs"></i>
							</button>
						</div>

						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->

					<ul class="nav nav-list">
						<li class="active">
							<a href="#">
								<i class="icon-dashboard"></i>
								<span class="menu-text"> 控制台 </span>
							</a>
						</li>


						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text">管理帖子</span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="../post/post.jsp" target="main">
										<i class="icon-double-angle-right"></i>
										发布帖子
									</a>
								</li>

								<li>
									<a href="findAll">
										<i class="icon-double-angle-right" target="main"></i>
										查看帖子
									</a>
								</li>

								<li>
									<a href="publish">
										<i class="icon-double-angle-right" target="main"></i>
										显示公告栏
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right" target="main"></i>
										功能四
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right" target="main"></i>
										功能五
									</a>
								</li>
							</ul>
						</li>



						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text">管理学生</span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="findAlls" target="main">
										<i class="icon-double-angle-right"></i>
										查看学生
									</a>
								</li>

								<li>
									<a href="#" target="main">
										<i class="icon-double-angle-right"></i>
										功能二
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能三
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能四
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能五
									</a>
								</li>
							</ul>
						</li>


						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text"> 管理学院和专业 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="findAllm" target="main">
										<i class="icon-double-angle-right"></i>
										查看学院和专业信息
									</a>
								</li>

								<li>
									<a href="../admin/addm.jsp">
										<i class="icon-double-angle-right"></i>
										增加专业
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能三
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能四
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能五
									</a>
								</li>
							</ul>
						</li>

						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text">管理教师 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="findAllt" target="main">
										<i class="icon-double-angle-right"></i>
										查看教师信息
									</a>
								</li>

								<li>
									<a href="../admin/addt.jsp" target="main">
										<i class="icon-double-angle-right"></i>
										增加教师
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能三
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能四
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能五
									</a>
								</li>
							</ul>
						</li>

						<!-- <li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text"> 模块五 </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能一
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能二
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能三
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能四
									</a>
								</li>

								<li>
									<a href="#">
										<i class="icon-double-angle-right"></i>
										功能五
									</a>
								</li>
							</ul>
						</li> -->

					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>

				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">Home</a>
							</li>

							<li>
								<a href="#">Other Pages</a>
							</li>
							<li class="active">Blank Page</li>
						</ul><!-- .breadcrumb -->

						<div class="nav-search" id="nav-search">
							<form class="form-search" style="position: relative;right: 60%;">
								<span class="input-icon">
									<input type="text" style="width: 400px;" placeholder="请输入关键字..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- #nav-search -->
					</div>

					<div class="page-content">
						<div class="row" id="main">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
									
								 
</body>
</html>
