卷 Data 的文件夹 PATH 列表
卷序列号为 9002-E44A
D:.
│  .gitignore
│  pom.xml
│  README.md
│  ssm_warehouse.iml
│  
├─.idea
│  │  .gitignore
│  │  compiler.xml
│  │  jarRepositories.xml
│  │  misc.xml
│  │  uiDesigner.xml
│  │  vcs.xml
│  │  workspace.xml
│  │  
│  └─inspectionProfiles
│          Project_Default.xml
│          
├─document
│  └─sql
│          ssm_warehouse.sql
│          
├─src
│  └─main
│      ├─java
│      │  └─com
│      │      └─luo
│      │          ├─controller
│      │          │  └─admin
│      │          │          DeptController.java
│      │          │          EmployeeController.java
│      │          │          FloorController.java
│      │          │          GoodController.java
│      │          │          MenuController.java
│      │          │          RoleController.java
│      │          │          RoomController.java
│      │          │          SystemController.java
│      │          │          
│      │          ├─dao
│      │          │      DeptMapper.java
│      │          │      EmployeeMapper.java
│      │          │      FloorMapper.java
│      │          │      GoodMapper.java
│      │          │      MenuMapper.java
│      │          │      RoleMapper.java
│      │          │      RoomMapper.java
│      │          │      
│      │          ├─entity
│      │          │      Dept.java
│      │          │      Employee.java
│      │          │      Floor.java
│      │          │      Good.java
│      │          │      Menu.java
│      │          │      Role.java
│      │          │      Room.java
│      │          │      
│      │          ├─interceptor
│      │          │      LoginInterceptor.java
│      │          │      
│      │          ├─service
│      │          │  │  DeptService.java
│      │          │  │  EmployeeService.java
│      │          │  │  FloorService.java
│      │          │  │  GoodService.java
│      │          │  │  MenuService.java
│      │          │  │  RoleService.java
│      │          │  │  RoomService.java
│      │          │  │  
│      │          │  └─impl
│      │          │          DeptServiceImpl.java
│      │          │          EmployeeServiceImpl.java
│      │          │          FloorServiceImpl.java
│      │          │          GoodServiceImpl.java
│      │          │          MenuServiceImpl.java
│      │          │          RoleServiceImpl.java
│      │          │          RoomServiceImpl.java
│      │          │          
│      │          ├─utils
│      │          │      DataGridViewResult.java
│      │          │      MenuNode.java
│      │          │      PasswordUtil.java
│      │          │      SystemConstant.java
│      │          │      TreeNode.java
│      │          │      TreeUtil.java
│      │          │      UUIDUtils.java
│      │          │      
│      │          └─vo
│      │                  DeptPieVO.java
│      │                  DeptVo.java
│      │                  EmployeeVo.java
│      │                  FloorVo.java
│      │                  GoodBarVO.java
│      │                  GoodVo.java
│      │                  MenuVo.java
│      │                  RoleVo.java
│      │                  RoomVo.java
│      │                  
│      ├─resources
│      │  │  applicationContext.xml
│      │  │  database.properties
│      │  │  log4j.properties
│      │  │  mybatis-config.xml
│      │  │  springmvc.xml
│      │  │  
│      │  └─mapper
│      │          DeptMapper.xml
│      │          EmployeeMapper.xml
│      │          FloorMapper.xml
│      │          GoodMapper.xml
│      │          MenuMapper.xml
│      │          RoleMapper.xml
│      │          RoomMapper.xml
│      │          
│      └─webapp
│          │  index.jsp
│          │  
│          ├─statics
│          │  ├─front
│          │  │  ├─css
│          │  │  │  │  global(1).css
│          │  │  │  │  global.css
│          │  │  │  │  store.css
│          │  │  │  │  
│          │  │  │  └─font
│          │  │  │          iconfont.eot
│          │  │  │          iconfont.svg
│          │  │  │          iconfont.ttf
│          │  │  │          iconfont.woff
│          │  │  │          iconfont.woff2
│          │  │  │          
│          │  │  ├─images
│          │  │  │      all_bg.jpg
│          │  │  │      favicon.ico
│          │  │  │      
│          │  │  └─layui
│          │  │      └─dist
│          │  │          │  layui.all.js
│          │  │          │  layui.js
│          │  │          │  
│          │  │          ├─css
│          │  │          │  │  layui.css
│          │  │          │  │  layui.mobile.css
│          │  │          │  │  
│          │  │          │  └─modules
│          │  │          │      │  code.css
│          │  │          │      │  
│          │  │          │      ├─laydate
│          │  │          │      │  └─default
│          │  │          │      │          laydate.css
│          │  │          │      │          
│          │  │          │      └─layer
│          │  │          │          └─default
│          │  │          │                  icon-ext.png
│          │  │          │                  icon.png
│          │  │          │                  layer.css
│          │  │          │                  loading-0.gif
│          │  │          │                  loading-1.gif
│          │  │          │                  loading-2.gif
│          │  │          │                  
│          │  │          ├─font
│          │  │          │      iconfont.eot
│          │  │          │      iconfont.svg
│          │  │          │      iconfont.ttf
│          │  │          │      iconfont.woff
│          │  │          │      iconfont.woff2
│          │  │          │      
│          │  │          ├─images
│          │  │          │  └─face
│          │  │          │          0.gif
│          │  │          │          1.gif
│          │  │          │          10.gif
│          │  │          │          11.gif
│          │  │          │          12.gif
│          │  │          │          13.gif
│          │  │          │          14.gif
│          │  │          │          15.gif
│          │  │          │          16.gif
│          │  │          │          17.gif
│          │  │          │          18.gif
│          │  │          │          19.gif
│          │  │          │          2.gif
│          │  │          │          20.gif
│          │  │          │          21.gif
│          │  │          │          22.gif
│          │  │          │          23.gif
│          │  │          │          24.gif
│          │  │          │          25.gif
│          │  │          │          26.gif
│          │  │          │          27.gif
│          │  │          │          28.gif
│          │  │          │          29.gif
│          │  │          │          3.gif
│          │  │          │          30.gif
│          │  │          │          31.gif
│          │  │          │          32.gif
│          │  │          │          33.gif
│          │  │          │          34.gif
│          │  │          │          35.gif
│          │  │          │          36.gif
│          │  │          │          37.gif
│          │  │          │          38.gif
│          │  │          │          39.gif
│          │  │          │          4.gif
│          │  │          │          40.gif
│          │  │          │          41.gif
│          │  │          │          42.gif
│          │  │          │          43.gif
│          │  │          │          44.gif
│          │  │          │          45.gif
│          │  │          │          46.gif
│          │  │          │          47.gif
│          │  │          │          48.gif
│          │  │          │          49.gif
│          │  │          │          5.gif
│          │  │          │          50.gif
│          │  │          │          51.gif
│          │  │          │          52.gif
│          │  │          │          53.gif
│          │  │          │          54.gif
│          │  │          │          55.gif
│          │  │          │          56.gif
│          │  │          │          57.gif
│          │  │          │          58.gif
│          │  │          │          59.gif
│          │  │          │          6.gif
│          │  │          │          60.gif
│          │  │          │          61.gif
│          │  │          │          62.gif
│          │  │          │          63.gif
│          │  │          │          64.gif
│          │  │          │          65.gif
│          │  │          │          66.gif
│          │  │          │          67.gif
│          │  │          │          68.gif
│          │  │          │          69.gif
│          │  │          │          7.gif
│          │  │          │          70.gif
│          │  │          │          71.gif
│          │  │          │          8.gif
│          │  │          │          9.gif
│          │  │          │          
│          │  │          └─lay
│          │  │              └─modules
│          │  │                      carousel.js
│          │  │                      code.js
│          │  │                      colorpicker.js
│          │  │                      element.js
│          │  │                      flow.js
│          │  │                      form.js
│          │  │                      jquery.js
│          │  │                      laydate.js
│          │  │                      layedit.js
│          │  │                      layer.js
│          │  │                      laypage.js
│          │  │                      laytpl.js
│          │  │                      mobile.js
│          │  │                      rate.js
│          │  │                      slider.js
│          │  │                      table.js
│          │  │                      transfer.js
│          │  │                      tree.js
│          │  │                      upload.js
│          │  │                      util.js
│          │  │                      
│          │  ├─layui
│          │  │  │  echarts.js
│          │  │  │  jquery-1.8.3.min.js
│          │  │  │  
│          │  │  ├─api
│          │  │  │      clear.json
│          │  │  │      init.json
│          │  │  │      menus.json
│          │  │  │      table.json
│          │  │  │      tableSelect.json
│          │  │  │      upload.json
│          │  │  │      
│          │  │  ├─css
│          │  │  │  │  layuimini.css
│          │  │  │  │  public.css
│          │  │  │  │  
│          │  │  │  └─themes
│          │  │  │          default.css
│          │  │  │          
│          │  │  ├─images
│          │  │  │      bg.jpg
│          │  │  │      captcha.jpg
│          │  │  │      donate_qrcode.png
│          │  │  │      favicon.ico
│          │  │  │      home.png
│          │  │  │      icon-login.png
│          │  │  │      loginbg.png
│          │  │  │      logo.png
│          │  │  │      
│          │  │  ├─js
│          │  │  │  │  lay-config.js
│          │  │  │  │  
│          │  │  │  └─lay-module
│          │  │  │      ├─echarts
│          │  │  │      │      echarts.js
│          │  │  │      │      echartsTheme.js
│          │  │  │      │      
│          │  │  │      ├─iconPicker
│          │  │  │      │      iconPickerFa.js
│          │  │  │      │      
│          │  │  │      ├─layarea
│          │  │  │      │      layarea.js
│          │  │  │      │      
│          │  │  │      ├─layuimini
│          │  │  │      │      miniAdmin.js
│          │  │  │      │      miniMenu.js
│          │  │  │      │      miniTab.js
│          │  │  │      │      miniTheme.js
│          │  │  │      │      miniTongji.js
│          │  │  │      │      
│          │  │  │      ├─step-lay
│          │  │  │      │      step.css
│          │  │  │      │      step.js
│          │  │  │      │      
│          │  │  │      ├─tableSelect
│          │  │  │      │      tableSelect.js
│          │  │  │      │      
│          │  │  │      ├─treetable-lay
│          │  │  │      │      treetable.css
│          │  │  │      │      treetable.js
│          │  │  │      │      
│          │  │  │      └─wangEditor
│          │  │  │          │  wangEditor.css
│          │  │  │          │  wangEditor.js
│          │  │  │          │  wangEditor.min.css
│          │  │  │          │  wangEditor.min.js
│          │  │  │          │  wangEditor.min.js.map
│          │  │  │          │  
│          │  │  │          └─fonts
│          │  │  │                  w-e-icon.woff
│          │  │  │                  
│          │  │  └─lib
│          │  │      ├─font-awesome-4.7.0
│          │  │      │  │  HELP-US-OUT.txt
│          │  │      │  │  
│          │  │      │  ├─css
│          │  │      │  │      font-awesome.css
│          │  │      │  │      font-awesome.min.css
│          │  │      │  │      
│          │  │      │  ├─fonts
│          │  │      │  │      fontawesome-webfont.eot
│          │  │      │  │      fontawesome-webfont.svg
│          │  │      │  │      fontawesome-webfont.ttf
│          │  │      │  │      fontawesome-webfont.woff
│          │  │      │  │      fontawesome-webfont.woff2
│          │  │      │  │      FontAwesome.otf
│          │  │      │  │      
│          │  │      │  ├─less
│          │  │      │  │      animated.less
│          │  │      │  │      bordered-pulled.less
│          │  │      │  │      core.less
│          │  │      │  │      fixed-width.less
│          │  │      │  │      font-awesome.less
│          │  │      │  │      icons.less
│          │  │      │  │      larger.less
│          │  │      │  │      list.less
│          │  │      │  │      mixins.less
│          │  │      │  │      path.less
│          │  │      │  │      rotated-flipped.less
│          │  │      │  │      screen-reader.less
│          │  │      │  │      stacked.less
│          │  │      │  │      variables.less
│          │  │      │  │      
│          │  │      │  └─scss
│          │  │      │          font-awesome.scss
│          │  │      │          _animated.scss
│          │  │      │          _bordered-pulled.scss
│          │  │      │          _core.scss
│          │  │      │          _fixed-width.scss
│          │  │      │          _icons.scss
│          │  │      │          _larger.scss
│          │  │      │          _list.scss
│          │  │      │          _mixins.scss
│          │  │      │          _path.scss
│          │  │      │          _rotated-flipped.scss
│          │  │      │          _screen-reader.scss
│          │  │      │          _stacked.scss
│          │  │      │          _variables.scss
│          │  │      │          
│          │  │      ├─jq-module
│          │  │      │  │  jquery.particleground.min.js
│          │  │      │  │  paigusu.min.js
│          │  │      │  │  
│          │  │      │  └─zyupload
│          │  │      │          zyupload-1.0.0.min.css
│          │  │      │          zyupload-1.0.0.min.js
│          │  │      │          
│          │  │      ├─jquery-3.4.1
│          │  │      │      jquery-3.4.1.min.js
│          │  │      │      
│          │  │      └─layui-v2.5.5
│          │  │          │  layui.all.js
│          │  │          │  layui.js
│          │  │          │  
│          │  │          ├─css
│          │  │          │  │  layui.css
│          │  │          │  │  layui.mobile.css
│          │  │          │  │  
│          │  │          │  └─modules
│          │  │          │      │  code.css
│          │  │          │      │  
│          │  │          │      ├─laydate
│          │  │          │      │  └─default
│          │  │          │      │          laydate.css
│          │  │          │      │          
│          │  │          │      └─layer
│          │  │          │          └─default
│          │  │          │                  icon-ext.png
│          │  │          │                  icon.png
│          │  │          │                  layer.css
│          │  │          │                  loading-0.gif
│          │  │          │                  loading-1.gif
│          │  │          │                  loading-2.gif
│          │  │          │                  
│          │  │          ├─font
│          │  │          │      iconfont.eot
│          │  │          │      iconfont.svg
│          │  │          │      iconfont.ttf
│          │  │          │      iconfont.woff
│          │  │          │      iconfont.woff2
│          │  │          │      
│          │  │          ├─images
│          │  │          │  └─face
│          │  │          │          0.gif
│          │  │          │          1.gif
│          │  │          │          10.gif
│          │  │          │          11.gif
│          │  │          │          12.gif
│          │  │          │          13.gif
│          │  │          │          14.gif
│          │  │          │          15.gif
│          │  │          │          16.gif
│          │  │          │          17.gif
│          │  │          │          18.gif
│          │  │          │          19.gif
│          │  │          │          2.gif
│          │  │          │          20.gif
│          │  │          │          21.gif
│          │  │          │          22.gif
│          │  │          │          23.gif
│          │  │          │          24.gif
│          │  │          │          25.gif
│          │  │          │          26.gif
│          │  │          │          27.gif
│          │  │          │          28.gif
│          │  │          │          29.gif
│          │  │          │          3.gif
│          │  │          │          30.gif
│          │  │          │          31.gif
│          │  │          │          32.gif
│          │  │          │          33.gif
│          │  │          │          34.gif
│          │  │          │          35.gif
│          │  │          │          36.gif
│          │  │          │          37.gif
│          │  │          │          38.gif
│          │  │          │          39.gif
│          │  │          │          4.gif
│          │  │          │          40.gif
│          │  │          │          41.gif
│          │  │          │          42.gif
│          │  │          │          43.gif
│          │  │          │          44.gif
│          │  │          │          45.gif
│          │  │          │          46.gif
│          │  │          │          47.gif
│          │  │          │          48.gif
│          │  │          │          49.gif
│          │  │          │          5.gif
│          │  │          │          50.gif
│          │  │          │          51.gif
│          │  │          │          52.gif
│          │  │          │          53.gif
│          │  │          │          54.gif
│          │  │          │          55.gif
│          │  │          │          56.gif
│          │  │          │          57.gif
│          │  │          │          58.gif
│          │  │          │          59.gif
│          │  │          │          6.gif
│          │  │          │          60.gif
│          │  │          │          61.gif
│          │  │          │          62.gif
│          │  │          │          63.gif
│          │  │          │          64.gif
│          │  │          │          65.gif
│          │  │          │          66.gif
│          │  │          │          67.gif
│          │  │          │          68.gif
│          │  │          │          69.gif
│          │  │          │          7.gif
│          │  │          │          70.gif
│          │  │          │          71.gif
│          │  │          │          8.gif
│          │  │          │          9.gif
│          │  │          │          
│          │  │          └─lay
│          │  │              └─modules
│          │  │                      carousel.js
│          │  │                      code.js
│          │  │                      colorpicker.js
│          │  │                      element.js
│          │  │                      flow.js
│          │  │                      form.js
│          │  │                      jquery.js
│          │  │                      laydate.js
│          │  │                      layedit.js
│          │  │                      layer.js
│          │  │                      laypage.js
│          │  │                      laytpl.js
│          │  │                      mobile.js
│          │  │                      rate.js
│          │  │                      slider.js
│          │  │                      table.js
│          │  │                      transfer.js
│          │  │                      tree.js
│          │  │                      upload.js
│          │  │                      util.js
│          │  │                      
│          │  └─layui_ext
│          │      ├─dist
│          │      │      dtree.js
│          │      │      
│          │      └─dtree
│          │          │  dtree.css
│          │          │  dtree.js
│          │          │  
│          │          └─font
│          │                  dtreefont.css
│          │                  dtreefont.eot
│          │                  dtreefont.svg
│          │                  dtreefont.ttf
│          │                  dtreefont.woff
│          │                  icons.json
│          │                  
│          └─WEB-INF
│              │  web.xml
│              │  
│              └─jsp
│                  └─admin
│                      │  desktop.jsp
│                      │  desktop3.jsp
│                      │  home.jsp
│                      │  login.jsp
│                      │  
│                      ├─dept
│                      │      deptManager.jsp
│                      │      
│                      ├─employee
│                      │      employeeManager.jsp
│                      │      
│                      ├─floor
│                      │      floorManager.jsp
│                      │      
│                      ├─good
│                      │      goodManager.jsp
│                      │      
│                      ├─menu
│                      │      menuManager.jsp
│                      │      
│                      ├─pie
│                      │      pieManager.jsp
│                      │      
│                      ├─role
│                      │      roleManager.jsp
│                      │      
│                      └─room
│                              roomManager.jsp
│                              
└─target
    │  ssm_warehouse-1.0-SNAPSHOT.war
    │  
    ├─classes
    │  │  applicationContext.xml
    │  │  database.properties
    │  │  log4j.properties
    │  │  mybatis-config.xml
    │  │  springmvc.xml
    │  │  
    │  ├─com
    │  │  └─luo
    │  │      ├─controller
    │  │      │  └─admin
    │  │      │          DeptController.class
    │  │      │          EmployeeController.class
    │  │      │          FloorController.class
    │  │      │          GoodController.class
    │  │      │          MenuController.class
    │  │      │          RoleController.class
    │  │      │          RoomController.class
    │  │      │          SystemController.class
    │  │      │          
    │  │      ├─dao
    │  │      │      DeptMapper.class
    │  │      │      EmployeeMapper.class
    │  │      │      FloorMapper.class
    │  │      │      GoodMapper.class
    │  │      │      MenuMapper.class
    │  │      │      RoleMapper.class
    │  │      │      RoomMapper.class
    │  │      │      
    │  │      ├─entity
    │  │      │      Dept.class
    │  │      │      Employee.class
    │  │      │      Floor.class
    │  │      │      Good.class
    │  │      │      Menu.class
    │  │      │      Role.class
    │  │      │      Room.class
    │  │      │      
    │  │      ├─interceptor
    │  │      │      LoginInterceptor.class
    │  │      │      
    │  │      ├─service
    │  │      │  │  DeptService.class
    │  │      │  │  EmployeeService.class
    │  │      │  │  FloorService.class
    │  │      │  │  GoodService.class
    │  │      │  │  MenuService.class
    │  │      │  │  RoleService.class
    │  │      │  │  RoomService.class
    │  │      │  │  
    │  │      │  └─impl
    │  │      │          DeptServiceImpl.class
    │  │      │          EmployeeServiceImpl.class
    │  │      │          FloorServiceImpl.class
    │  │      │          GoodServiceImpl.class
    │  │      │          MenuServiceImpl.class
    │  │      │          RoleServiceImpl.class
    │  │      │          RoomServiceImpl.class
    │  │      │          
    │  │      ├─utils
    │  │      │      DataGridViewResult.class
    │  │      │      MenuNode.class
    │  │      │      PasswordUtil.class
    │  │      │      SystemConstant.class
    │  │      │      TreeNode.class
    │  │      │      TreeUtil.class
    │  │      │      UUIDUtils.class
    │  │      │      
    │  │      └─vo
    │  │              DeptPieVO.class
    │  │              DeptVo.class
    │  │              EmployeeVo.class
    │  │              FloorVo.class
    │  │              GoodBarVO.class
    │  │              GoodVo.class
    │  │              MenuVo.class
    │  │              RoleVo.class
    │  │              RoomVo.class
    │  │              
    │  └─mapper
    │          DeptMapper.xml
    │          EmployeeMapper.xml
    │          FloorMapper.xml
    │          GoodMapper.xml
    │          MenuMapper.xml
    │          RoleMapper.xml
    │          RoomMapper.xml
    │          
    ├─generated-sources
    │  └─annotations
    ├─maven-archiver
    │      pom.properties
    │      
    ├─maven-status
    │  └─maven-compiler-plugin
    │      └─compile
    │          └─default-compile
    │                  createdFiles.lst
    │                  inputFiles.lst
    │                  
    └─ssm_warehouse-1.0-SNAPSHOT
        │  index.jsp
        │  
        ├─META-INF
        │      MANIFEST.MF
        │      
        ├─statics
        │  ├─front
        │  │  ├─css
        │  │  │  │  global(1).css
        │  │  │  │  global.css
        │  │  │  │  store.css
        │  │  │  │  
        │  │  │  └─font
        │  │  │          iconfont.eot
        │  │  │          iconfont.svg
        │  │  │          iconfont.ttf
        │  │  │          iconfont.woff
        │  │  │          iconfont.woff2
        │  │  │          
        │  │  ├─images
        │  │  │      all_bg.jpg
        │  │  │      favicon.ico
        │  │  │      
        │  │  └─layui
        │  │      └─dist
        │  │          │  layui.all.js
        │  │          │  layui.js
        │  │          │  
        │  │          ├─css
        │  │          │  │  layui.css
        │  │          │  │  layui.mobile.css
        │  │          │  │  
        │  │          │  └─modules
        │  │          │      │  code.css
        │  │          │      │  
        │  │          │      ├─laydate
        │  │          │      │  └─default
        │  │          │      │          laydate.css
        │  │          │      │          
        │  │          │      └─layer
        │  │          │          └─default
        │  │          │                  icon-ext.png
        │  │          │                  icon.png
        │  │          │                  layer.css
        │  │          │                  loading-0.gif
        │  │          │                  loading-1.gif
        │  │          │                  loading-2.gif
        │  │          │                  
        │  │          ├─font
        │  │          │      iconfont.eot
        │  │          │      iconfont.svg
        │  │          │      iconfont.ttf
        │  │          │      iconfont.woff
        │  │          │      iconfont.woff2
        │  │          │      
        │  │          ├─images
        │  │          │  └─face
        │  │          │          0.gif
        │  │          │          1.gif
        │  │          │          10.gif
        │  │          │          11.gif
        │  │          │          12.gif
        │  │          │          13.gif
        │  │          │          14.gif
        │  │          │          15.gif
        │  │          │          16.gif
        │  │          │          17.gif
        │  │          │          18.gif
        │  │          │          19.gif
        │  │          │          2.gif
        │  │          │          20.gif
        │  │          │          21.gif
        │  │          │          22.gif
        │  │          │          23.gif
        │  │          │          24.gif
        │  │          │          25.gif
        │  │          │          26.gif
        │  │          │          27.gif
        │  │          │          28.gif
        │  │          │          29.gif
        │  │          │          3.gif
        │  │          │          30.gif
        │  │          │          31.gif
        │  │          │          32.gif
        │  │          │          33.gif
        │  │          │          34.gif
        │  │          │          35.gif
        │  │          │          36.gif
        │  │          │          37.gif
        │  │          │          38.gif
        │  │          │          39.gif
        │  │          │          4.gif
        │  │          │          40.gif
        │  │          │          41.gif
        │  │          │          42.gif
        │  │          │          43.gif
        │  │          │          44.gif
        │  │          │          45.gif
        │  │          │          46.gif
        │  │          │          47.gif
        │  │          │          48.gif
        │  │          │          49.gif
        │  │          │          5.gif
        │  │          │          50.gif
        │  │          │          51.gif
        │  │          │          52.gif
        │  │          │          53.gif
        │  │          │          54.gif
        │  │          │          55.gif
        │  │          │          56.gif
        │  │          │          57.gif
        │  │          │          58.gif
        │  │          │          59.gif
        │  │          │          6.gif
        │  │          │          60.gif
        │  │          │          61.gif
        │  │          │          62.gif
        │  │          │          63.gif
        │  │          │          64.gif
        │  │          │          65.gif
        │  │          │          66.gif
        │  │          │          67.gif
        │  │          │          68.gif
        │  │          │          69.gif
        │  │          │          7.gif
        │  │          │          70.gif
        │  │          │          71.gif
        │  │          │          8.gif
        │  │          │          9.gif
        │  │          │          
        │  │          └─lay
        │  │              └─modules
        │  │                      carousel.js
        │  │                      code.js
        │  │                      colorpicker.js
        │  │                      element.js
        │  │                      flow.js
        │  │                      form.js
        │  │                      jquery.js
        │  │                      laydate.js
        │  │                      layedit.js
        │  │                      layer.js
        │  │                      laypage.js
        │  │                      laytpl.js
        │  │                      mobile.js
        │  │                      rate.js
        │  │                      slider.js
        │  │                      table.js
        │  │                      transfer.js
        │  │                      tree.js
        │  │                      upload.js
        │  │                      util.js
        │  │                      
        │  ├─layui
        │  │  │  echarts.js
        │  │  │  jquery-1.8.3.min.js
        │  │  │  
        │  │  ├─api
        │  │  │      clear.json
        │  │  │      init.json
        │  │  │      menus.json
        │  │  │      table.json
        │  │  │      tableSelect.json
        │  │  │      upload.json
        │  │  │      
        │  │  ├─css
        │  │  │  │  layuimini.css
        │  │  │  │  public.css
        │  │  │  │  
        │  │  │  └─themes
        │  │  │          default.css
        │  │  │          
        │  │  ├─images
        │  │  │      bg.jpg
        │  │  │      captcha.jpg
        │  │  │      donate_qrcode.png
        │  │  │      favicon.ico
        │  │  │      home.png
        │  │  │      icon-login.png
        │  │  │      loginbg.png
        │  │  │      logo.png
        │  │  │      
        │  │  ├─js
        │  │  │  │  lay-config.js
        │  │  │  │  
        │  │  │  └─lay-module
        │  │  │      ├─echarts
        │  │  │      │      echarts.js
        │  │  │      │      echartsTheme.js
        │  │  │      │      
        │  │  │      ├─iconPicker
        │  │  │      │      iconPickerFa.js
        │  │  │      │      
        │  │  │      ├─layarea
        │  │  │      │      layarea.js
        │  │  │      │      
        │  │  │      ├─layuimini
        │  │  │      │      miniAdmin.js
        │  │  │      │      miniMenu.js
        │  │  │      │      miniTab.js
        │  │  │      │      miniTheme.js
        │  │  │      │      miniTongji.js
        │  │  │      │      
        │  │  │      ├─step-lay
        │  │  │      │      step.css
        │  │  │      │      step.js
        │  │  │      │      
        │  │  │      ├─tableSelect
        │  │  │      │      tableSelect.js
        │  │  │      │      
        │  │  │      ├─treetable-lay
        │  │  │      │      treetable.css
        │  │  │      │      treetable.js
        │  │  │      │      
        │  │  │      └─wangEditor
        │  │  │          │  wangEditor.css
        │  │  │          │  wangEditor.js
        │  │  │          │  wangEditor.min.css
        │  │  │          │  wangEditor.min.js
        │  │  │          │  wangEditor.min.js.map
        │  │  │          │  
        │  │  │          └─fonts
        │  │  │                  w-e-icon.woff
        │  │  │                  
        │  │  └─lib
        │  │      ├─font-awesome-4.7.0
        │  │      │  │  HELP-US-OUT.txt
        │  │      │  │  
        │  │      │  ├─css
        │  │      │  │      font-awesome.css
        │  │      │  │      font-awesome.min.css
        │  │      │  │      
        │  │      │  ├─fonts
        │  │      │  │      fontawesome-webfont.eot
        │  │      │  │      fontawesome-webfont.svg
        │  │      │  │      fontawesome-webfont.ttf
        │  │      │  │      fontawesome-webfont.woff
        │  │      │  │      fontawesome-webfont.woff2
        │  │      │  │      FontAwesome.otf
        │  │      │  │      
        │  │      │  ├─less
        │  │      │  │      animated.less
        │  │      │  │      bordered-pulled.less
        │  │      │  │      core.less
        │  │      │  │      fixed-width.less
        │  │      │  │      font-awesome.less
        │  │      │  │      icons.less
        │  │      │  │      larger.less
        │  │      │  │      list.less
        │  │      │  │      mixins.less
        │  │      │  │      path.less
        │  │      │  │      rotated-flipped.less
        │  │      │  │      screen-reader.less
        │  │      │  │      stacked.less
        │  │      │  │      variables.less
        │  │      │  │      
        │  │      │  └─scss
        │  │      │          font-awesome.scss
        │  │      │          _animated.scss
        │  │      │          _bordered-pulled.scss
        │  │      │          _core.scss
        │  │      │          _fixed-width.scss
        │  │      │          _icons.scss
        │  │      │          _larger.scss
        │  │      │          _list.scss
        │  │      │          _mixins.scss
        │  │      │          _path.scss
        │  │      │          _rotated-flipped.scss
        │  │      │          _screen-reader.scss
        │  │      │          _stacked.scss
        │  │      │          _variables.scss
        │  │      │          
        │  │      ├─jq-module
        │  │      │  │  jquery.particleground.min.js
        │  │      │  │  paigusu.min.js
        │  │      │  │  
        │  │      │  └─zyupload
        │  │      │          zyupload-1.0.0.min.css
        │  │      │          zyupload-1.0.0.min.js
        │  │      │          
        │  │      ├─jquery-3.4.1
        │  │      │      jquery-3.4.1.min.js
        │  │      │      
        │  │      └─layui-v2.5.5
        │  │          │  layui.all.js
        │  │          │  layui.js
        │  │          │  
        │  │          ├─css
        │  │          │  │  layui.css
        │  │          │  │  layui.mobile.css
        │  │          │  │  
        │  │          │  └─modules
        │  │          │      │  code.css
        │  │          │      │  
        │  │          │      ├─laydate
        │  │          │      │  └─default
        │  │          │      │          laydate.css
        │  │          │      │          
        │  │          │      └─layer
        │  │          │          └─default
        │  │          │                  icon-ext.png
        │  │          │                  icon.png
        │  │          │                  layer.css
        │  │          │                  loading-0.gif
        │  │          │                  loading-1.gif
        │  │          │                  loading-2.gif
        │  │          │                  
        │  │          ├─font
        │  │          │      iconfont.eot
        │  │          │      iconfont.svg
        │  │          │      iconfont.ttf
        │  │          │      iconfont.woff
        │  │          │      iconfont.woff2
        │  │          │      
        │  │          ├─images
        │  │          │  └─face
        │  │          │          0.gif
        │  │          │          1.gif
        │  │          │          10.gif
        │  │          │          11.gif
        │  │          │          12.gif
        │  │          │          13.gif
        │  │          │          14.gif
        │  │          │          15.gif
        │  │          │          16.gif
        │  │          │          17.gif
        │  │          │          18.gif
        │  │          │          19.gif
        │  │          │          2.gif
        │  │          │          20.gif
        │  │          │          21.gif
        │  │          │          22.gif
        │  │          │          23.gif
        │  │          │          24.gif
        │  │          │          25.gif
        │  │          │          26.gif
        │  │          │          27.gif
        │  │          │          28.gif
        │  │          │          29.gif
        │  │          │          3.gif
        │  │          │          30.gif
        │  │          │          31.gif
        │  │          │          32.gif
        │  │          │          33.gif
        │  │          │          34.gif
        │  │          │          35.gif
        │  │          │          36.gif
        │  │          │          37.gif
        │  │          │          38.gif
        │  │          │          39.gif
        │  │          │          4.gif
        │  │          │          40.gif
        │  │          │          41.gif
        │  │          │          42.gif
        │  │          │          43.gif
        │  │          │          44.gif
        │  │          │          45.gif
        │  │          │          46.gif
        │  │          │          47.gif
        │  │          │          48.gif
        │  │          │          49.gif
        │  │          │          5.gif
        │  │          │          50.gif
        │  │          │          51.gif
        │  │          │          52.gif
        │  │          │          53.gif
        │  │          │          54.gif
        │  │          │          55.gif
        │  │          │          56.gif
        │  │          │          57.gif
        │  │          │          58.gif
        │  │          │          59.gif
        │  │          │          6.gif
        │  │          │          60.gif
        │  │          │          61.gif
        │  │          │          62.gif
        │  │          │          63.gif
        │  │          │          64.gif
        │  │          │          65.gif
        │  │          │          66.gif
        │  │          │          67.gif
        │  │          │          68.gif
        │  │          │          69.gif
        │  │          │          7.gif
        │  │          │          70.gif
        │  │          │          71.gif
        │  │          │          8.gif
        │  │          │          9.gif
        │  │          │          
        │  │          └─lay
        │  │              └─modules
        │  │                      carousel.js
        │  │                      code.js
        │  │                      colorpicker.js
        │  │                      element.js
        │  │                      flow.js
        │  │                      form.js
        │  │                      jquery.js
        │  │                      laydate.js
        │  │                      layedit.js
        │  │                      layer.js
        │  │                      laypage.js
        │  │                      laytpl.js
        │  │                      mobile.js
        │  │                      rate.js
        │  │                      slider.js
        │  │                      table.js
        │  │                      transfer.js
        │  │                      tree.js
        │  │                      upload.js
        │  │                      util.js
        │  │                      
        │  └─layui_ext
        │      ├─dist
        │      │      dtree.js
        │      │      
        │      └─dtree
        │          │  dtree.css
        │          │  dtree.js
        │          │  
        │          └─font
        │                  dtreefont.css
        │                  dtreefont.eot
        │                  dtreefont.svg
        │                  dtreefont.ttf
        │                  dtreefont.woff
        │                  icons.json
        │                  
        └─WEB-INF
            │  web.xml
            │  
            ├─classes
            │  │  applicationContext.xml
            │  │  database.properties
            │  │  log4j.properties
            │  │  mybatis-config.xml
            │  │  springmvc.xml
            │  │  
            │  ├─com
            │  │  └─luo
            │  │      ├─config
            │  │      ├─controller
            │  │      │  └─admin
            │  │      │          DeptController.class
            │  │      │          EmployeeController.class
            │  │      │          FloorController.class
            │  │      │          GoodController.class
            │  │      │          MenuController.class
            │  │      │          RoleController.class
            │  │      │          RoomController.class
            │  │      │          SystemController.class
            │  │      │          
            │  │      ├─dao
            │  │      │      DeptMapper.class
            │  │      │      EmployeeMapper.class
            │  │      │      FloorMapper.class
            │  │      │      GoodMapper.class
            │  │      │      MenuMapper.class
            │  │      │      RoleMapper.class
            │  │      │      RoomMapper.class
            │  │      │      
            │  │      ├─entity
            │  │      │      Dept.class
            │  │      │      Employee.class
            │  │      │      Floor.class
            │  │      │      Good.class
            │  │      │      Menu.class
            │  │      │      Role.class
            │  │      │      Room.class
            │  │      │      
            │  │      ├─interceptor
            │  │      │      LoginInterceptor.class
            │  │      │      
            │  │      ├─service
            │  │      │  │  DeptService.class
            │  │      │  │  EmployeeService.class
            │  │      │  │  FloorService.class
            │  │      │  │  GoodService.class
            │  │      │  │  MenuService.class
            │  │      │  │  RoleService.class
            │  │      │  │  RoomService.class
            │  │      │  │  
            │  │      │  └─impl
            │  │      │          DeptServiceImpl.class
            │  │      │          EmployeeServiceImpl.class
            │  │      │          FloorServiceImpl.class
            │  │      │          GoodServiceImpl.class
            │  │      │          MenuServiceImpl.class
            │  │      │          RoleServiceImpl.class
            │  │      │          RoomServiceImpl.class
            │  │      │          
            │  │      ├─utils
            │  │      │      DataGridViewResult.class
            │  │      │      MenuNode.class
            │  │      │      PasswordUtil.class
            │  │      │      SystemConstant.class
            │  │      │      TreeNode.class
            │  │      │      TreeUtil.class
            │  │      │      UUIDUtils.class
            │  │      │      
            │  │      └─vo
            │  │              DeptPieVO.class
            │  │              DeptVo.class
            │  │              EmployeeVo.class
            │  │              FloorVo.class
            │  │              GoodBarVO.class
            │  │              GoodVo.class
            │  │              MenuVo.class
            │  │              RoleVo.class
            │  │              RoomVo.class
            │  │              
            │  └─mapper
            │          DeptMapper.xml
            │          EmployeeMapper.xml
            │          FloorMapper.xml
            │          GoodMapper.xml
            │          MenuMapper.xml
            │          RoleMapper.xml
            │          RoomMapper.xml
            │          
            ├─jsp
            │  └─admin
            │      │  desktop.jsp
            │      │  desktop3.jsp
            │      │  home.jsp
            │      │  login.jsp
            │      │  
            │      ├─dept
            │      │      deptManager.jsp
            │      │      
            │      ├─employee
            │      │      employeeManager.jsp
            │      │      
            │      ├─floor
            │      │      floorManager.jsp
            │      │      
            │      ├─good
            │      │      goodManager.jsp
            │      │      
            │      ├─media
            │      │  └─icons
            │      ├─menu
            │      │      menuManager.jsp
            │      │      
            │      ├─pie
            │      │      pieManager.jsp
            │      │      
            │      ├─role
            │      │      roleManager.jsp
            │      │      
            │      └─room
            │              roomManager.jsp
            │              
            └─lib
                    aspectjweaver-1.8.7.jar
                    classmate-1.3.1.jar
                    commons-beanutils-1.9.4.jar
                    commons-collections-3.2.2.jar
                    commons-dbcp-1.4.jar
                    commons-fileupload-1.4.jar
                    commons-io-2.7.jar
                    commons-logging-1.2.jar
                    commons-pool-1.5.4.jar
                    fastjson-1.2.73.jar
                    hibernate-validator-5.4.3.Final.jar
                    jackson-annotations-2.9.0.jar
                    jackson-core-2.9.0.jar
                    jackson-databind-2.9.0.jar
                    jboss-logging-3.3.0.Final.jar
                    jsqlparser-3.2.jar
                    jstl-1.2.jar
                    log4j-1.2.17.jar
                    mybatis-3.5.5.jar
                    mybatis-spring-2.0.5.jar
                    mysql-connector-java-8.0.19.jar
                    pagehelper-5.2.0.jar
                    protobuf-java-3.6.1.jar
                    shiro-cache-1.6.0.jar
                    shiro-config-core-1.6.0.jar
                    shiro-config-ogdl-1.6.0.jar
                    shiro-core-1.6.0.jar
                    shiro-crypto-cipher-1.6.0.jar
                    shiro-crypto-core-1.6.0.jar
                    shiro-crypto-hash-1.6.0.jar
                    shiro-event-1.6.0.jar
                    shiro-lang-1.6.0.jar
                    slf4j-api-1.7.26.jar
                    spring-aop-5.2.8.RELEASE.jar
                    spring-beans-5.2.8.RELEASE.jar
                    spring-context-5.2.8.RELEASE.jar
                    spring-core-5.2.8.RELEASE.jar
                    spring-expression-5.2.8.RELEASE.jar
                    spring-jcl-5.2.8.RELEASE.jar
                    spring-jdbc-5.2.8.RELEASE.jar
                    spring-test-5.2.8.RELEASE.jar
                    spring-tx-5.2.8.RELEASE.jar
                    spring-web-5.2.8.RELEASE.jar
                    spring-webmvc-5.2.8.RELEASE.jar
                    validation-api-1.1.0.Final.jar
                    
