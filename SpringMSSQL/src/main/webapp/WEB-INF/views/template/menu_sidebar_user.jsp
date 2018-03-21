 <!-- Left side column. contains the logo and sidebar -->
 <aside class="main-sidebar">
  <!-- sidebar: style can be found in sidebar.less -->
  <section class="sidebar">
    <!-- Sidebar user panel -->
    <div class="user-panel">
      <div class="pull-left image">
        <img src="resources/libs/admin-lte2/img/user.png" class="img-circle" alt="User Image">
      </div>
      <div class="pull-left info">
        <p>${user.firstName} ${user.lastName}</p>
        <a href="">${user.username}</a>
      </div>
    </div>    
    <!-- /.search form -->
    <!-- sidebar menu: : style can be found in sidebar.less -->
    <ul class="sidebar-menu">
      <li class="header">MAIN NAVIGATION</li>
      <li class="active treeview">
        <a href="#">
          <i class="fa fa-dashboard" style="height: 20px;"></i> <span>Dashboard</span>
          <span class="pull-right-container">
            <i class="fa fa-angle-left pull-right"></i>
          </span>
        </a>
        <ul class="treeview-menu">
          <li><a href="index.html"><i class="fa fa-circle-o"></i> Dashboard v1</a></li>
          <li class="active"><a href="index2.html"><i class="fa fa-circle-o"></i> Dashboard v2</a></li>
        </ul>
      </li>
      <li>
        <a href="#">
          <i class="fa fa-calendar" style="height: 20px;"></i> <span>Calendar</span>
          <span class="pull-right-container">
            <small class="label pull-right bg-red">1</small>
          </span>
        </a>
      </li>
    </ul>
  </section>
  <!-- /.sidebar -->
</aside>