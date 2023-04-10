<template>
<!--根据模板新增-->
  <div class="app-container">
    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open3" width="500px" append-to-body>
      <el-form >
        <el-form-item label="选择排班模板" >
          <div style="margin-left: 30px">
          <el-select v-model="selectedForm" placeholder="请选择模板"  >
            <el-option v-for="name in scheduleForms" :key="name" :label="name" :value="name"></el-option>
          </el-select>
          </div>
        </el-form-item>
        <el-button type="primary" @click="addByForm">搜索排班</el-button>
      </el-form>
    </el-dialog>



<!--    挑选弹窗-->
    <el-dialog :title="title" :visible.sync="open2" width="500px" append-to-body>
      <el-form>
        <div style="text-align:center;">
          <el-form-item label="选择科室">
            <el-select v-model="selectedDept1" placeholder="请选择" @change="getDept2">
              <el-option v-for="deptName in dept1" :key="deptName" :label="deptName" :value="deptName"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="选择部门">
            <el-select v-model="selectedDept2" placeholder="请选择" :disabled="!selectedDept1" @change="getDoctor" >
              <el-option v-for="deptName in dept2" :key="deptName" :label="deptName" :value="deptName"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="选择医生">
            <el-select v-model="selectDoctor" placeholder="请选择" :disabled="!selectedDept2"  @change="clearCityAndCounty">
              <el-option v-for="nickName in doctors" :key="nickName" :label="nickName" :value="nickName"></el-option>
            </el-select>
          </el-form-item>
          <div class="block" label="选择日期" style="margin-left: 65px;margin-bottom: 30px;" >
            <el-date-picker
              v-model="datetime"
              type="date"
              placeholder="选择日期"
              >
            </el-date-picker>
          </div>
          <el-button type="primary" @click="getList">搜索排班</el-button>
        </div>
      </el-form>
    </el-dialog>


    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="医生编号" prop="doctorId" style="margin-bottom: 20px;">
        <el-input
          v-model="queryParams.doctorId"
          placeholder="请输入医生编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="开始时间" prop="startTime" style="margin-bottom: 20px;margin-left: 30px">
        <el-input
          v-model="queryParams.startTime"
          placeholder="请输入开始时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="结束时间" prop="endTime" style="margin-bottom: 20px;margin-left: 30px">
        <el-input
          v-model="queryParams.endTime"
          placeholder="请输入结束时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="模板名称" prop="parentId" style="margin-bottom: 20px;margin-left: 30px">
        <el-input
          v-model="queryParams.parentId"
          placeholder="请输入模板名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="日" prop="day" style="">
        <el-input
          v-model="queryParams.day"
          placeholder="请输入查询日"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="周" prop="week" style="margin-left: 30px;">
        <el-input
          v-model="queryParams.week"
          placeholder="请输入查询周"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="月" prop="month" style="margin-left: 30px;">
        <el-input
          v-model="queryParams.month"
          placeholder="请输入月"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年" prop="year" style="margin-right: 100px;">
        <el-input
          v-model="queryParams.year"
          placeholder="请输入查询年"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item style="margin-left: 500px;">
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="changeopen2">重选</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:schedule:add']"
        >新增</el-button>
      </el-col>

      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:schedule:edit']"
        >修改</el-button>
      </el-col>

      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:schedule:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:schedule:export']"
        >导出</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="insertByForm"
        >排班模板新增</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="scheduleList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="排班编号" align="center" prop="id" />
      <el-table-column label="医生姓名" align="center" prop="doctorName" />
      <el-table-column label="医生编号" align="center" prop="doctorId" />
      <el-table-column label="开始时间" align="center" prop="startTime" />
      <el-table-column label="结束时间" align="center" prop="endTime" />
      <el-table-column label="模板名称" align="center" prop="schduleFormName" />
      <el-table-column label="周" align="center" prop="week" />
      <el-table-column label="日" align="center" prop="day" />
      <el-table-column label="月" align="center" prop="month" />
      <el-table-column label="年" align="center" prop="year" />
      <el-table-column label="状态" align="center" prop="statusName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:schedule:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:schedule:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />


    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="开始时间" prop="startTime">
          <el-input v-model="form.startTime" placeholder="请输入开始时间" />
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-input v-model="form.endTime" placeholder="请输入结束时间" />
        </el-form-item>

        <el-form-item label="排班状态" prop="choosestatus">

        <el-select v-model="choosestatus" placeholder="请选择">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.choosestatus"
          >
          </el-option>
        </el-select>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listSchedule, getSchedule, delSchedule, addSchedule, updateSchedule,addByForm } from "@/api/system/schedule";
import { listDept,listDeptByName } from "@/api/system/dept";
import { listByUserName,listByDeptName} from "@/api/system/user";
import { listForm } from "@/api/system/form";

export default {
  name: "Schedule",
  data() {
    return {
      year: ['2022年', '2023年', '2024年'],
      month: {
        '2022年': ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
        '2023年': ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月'],
        '2024年': ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
      },
      day: {
        '1月':['1日','2日','3日','4日','5日','6日','7日','8日','9日','10日','11日','12日','13日','14日','15日','16日','17日','18日','19日','20日','21日','22日','23日','24日','25日','26日','27日','28日','29日','30日','31日'],
        '2月':['1日','2日','3日','4日','5日','6日','7日','8日','9日','10日','11日','12日','13日','14日','15日','16日','17日','18日','19日','20日','21日','22日','23日','24日','25日','26日','27日','28日','29日'],
        '3月':['1日','2日','3日','4日','5日','6日','7日','8日','9日','10日','11日','12日','13日','14日','15日','16日','17日','18日','19日','20日','21日','22日','23日','24日','25日','26日','27日','28日','29日','30日','31日'],
        '4月':['1日','2日','3日','4日','5日','6日','7日','8日','9日','10日','11日','12日','13日','14日','15日','16日','17日','18日','19日','20日','21日','22日','23日','24日','25日','26日','27日','28日','29日','30日'],
        '5月':['1日','2日','3日','4日','5日','6日','7日','8日','9日','10日','11日','12日','13日','14日','15日','16日','17日','18日','19日','20日','21日','22日','23日','24日','25日','26日','27日','28日','29日','30日','31日'],
        '6月':['1日','2日','3日','4日','5日','6日','7日','8日','9日','10日','11日','12日','13日','14日','15日','16日','17日','18日','19日','20日','21日','22日','23日','24日','25日','26日','27日','28日','29日','30日'],
        '7月':['1日','2日','3日','4日','5日','6日','7日','8日','9日','10日','11日','12日','13日','14日','15日','16日','17日','18日','19日','20日','21日','22日','23日','24日','25日','26日','27日','28日','29日','30日','31日'],
        '8月':['1日','2日','3日','4日','5日','6日','7日','8日','9日','10日','11日','12日','13日','14日','15日','16日','17日','18日','19日','20日','21日','22日','23日','24日','25日','26日','27日','28日','29日','30日','31日'],
        '9月':['1日','2日','3日','4日','5日','6日','7日','8日','9日','10日','11日','12日','13日','14日','15日','16日','17日','18日','19日','20日','21日','22日','23日','24日','25日','26日','27日','28日','29日','30日'],
        '10月':['1日','2日','3日','4日','5日','6日','7日','8日','9日','10日','11日','12日','13日','14日','15日','16日','17日','18日','19日','20日','21日','22日','23日','24日','25日','26日','27日','28日','29日','30日','31日'],
        '11月':['1日','2日','3日','4日','5日','6日','7日','8日','9日','10日','11日','12日','13日','14日','15日','16日','17日','18日','19日','20日','21日','22日','23日','24日','25日','26日','27日','28日','29日','30日'],
        '12月':['1日','2日','3日','4日','5日','6日','7日','8日','9日','10日','11日','12日','13日','14日','15日','16日','17日','18日','19日','20日','21日','22日','23日','24日','25日','26日','27日','28日','29日','30日','31日']

      },
      selectedProvince: '',
      selectedCity: '',
      selectedCounty: '',
      dept1:[],
      selectedDept1: '',
      dept2:[],
      selectedDept2: '',
      doctors:[],
      selectDoctor: '',
      datetime: '',

      scheduleForms:[],
      selectedForm: '',

      options: [{
        choosestatus: '0',
        label: '未支付'
      }, {
        choosestatus: '1',
        label: '支付中'
      }, {
        choosestatus: '2',
        label: '支付超时'
      }, {
        choosestatus: '3',
        label: '待使用'
      }, {
        choosestatus: '4',
        label: '使用完成'
      },{
        choosestatus: '5',
        label: '未预约'
      },{
        choosestatus: '6',
        label: '待预约'
      }],
      choosestatus: '',

      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      parentId: 0,
      // 【请填写功能名称】表格数据
      scheduleList: [],
      deptParentList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      open2: true,
      open3:false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        doctorId: null,
        startTime: null,
        endTime: null,
        parentId: null,
        day: null,
        week: null,
        month: null,
        year: null,
        statusName: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },

  computed: {

    // 动态计算当前可选的城市列表
    availableCities() {
      if (this.selectedProvince && this.month[this.selectedProvince]) {
        return this.month[this.selectedProvince]
      } else {
        return []
      }
    },
    // 动态计算当前可选的县列表
    availableCounties() {
      if (this.selectedCity && this.day[this.selectedCity]) {
        return this.day[this.selectedCity]
      } else {
        return []
      }
    }
  },
  created() {
    this.getDept1List(100);
    this.getFrom();
  },
  methods: {
    changeopen2(){
      this.open2 = true;
    },
    getDoctor(){
      this.doctors=[];
      this.selectDoctor='';
      var name=this.selectedDept2
      listByDeptName( {name}).then(response => {
        this.doctors = response.data.map(data => data.nickName);
      })
    },
    getDept2(){
      this.dept2=[];
      this.selectedDept2='';
      var name=this.selectedDept1
      listDeptByName( {name}).then(response => {
        this.dept2 = response.data.map(data => data.deptName);
      })

    },

    getFrom(){
      listForm().then(response => {
        this.scheduleForms = response.rows.map(data => data.name);
      })
    },

    getDept1List(parentId) {
      this.loading = true;
      listDept({ parentId }).then(response => {
        this.dept1 = response.data.map(data => data.deptName);
      })
    },
    getList() {
      this.loading = true;
      this.queryParams.year = this.datetime.getFullYear();
      this.queryParams.month = this.datetime.getMonth()+1;
      this.queryParams.day = this.datetime.getDate();
      console.log(this.datetime.getDate());
      var doctorName = this.selectDoctor;
      if (doctorName == null || doctorName == undefined || doctorName == '') {
        this.$message.error("未选择医生");
        return;
      }
      else{
        listByUserName({doctorName}).then(response => {
          this.queryParams.doctorId= response.data.userId;
        });
        listSchedule(this.queryParams).then(response => {
          this.scheduleList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
        this.open2=false;
      }

    },
    // 清空当前选中的城市和县
    clearCityAndCounty() {
      this.selectedCity = ''
      this.selectedCounty = ''
    },
    // 清空当前选中的县
    clearCounty() {
      this.selectedCounty = ''
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        doctorId: null,
        startTime: null,
        endTime: null,
        parentId: null,
        day: null,
        week: null,
        month: null,
        year: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    addByForm(){

      addByForm(this.form).then(response => {
        this.$modal.msgSuccess("新增成功");
        this.open = false;
        this.getList();
      });
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加排班";
    },
    insertByForm(){
        this.open3=true;
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getSchedule(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改该排班时间";

      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            var doctorName = this.selectDoctor;
            if (doctorName != null) {
              listByUserName({doctorName}).then(response => {
                this.form.doctorId= response.rows.userId;
              });
            }
            this.form.year = this.datetime.getFullYear();
            this.form.month =this.datetime.getMonth()+1;
            this.form.day = this.datetime.getDate();
            this.form.status=this.choosestatus;
            updateSchedule(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            this.form.status = this.choosestatus;
            this.form.year = this.datetime.getFullYear();
            this.form.month =this.datetime.getMonth()+1;
            this.form.day = this.datetime.getDate();
            this.form.doctorName=this.selectDoctor;
            addSchedule(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除编号"' + ids + '"的排班？').then(function () {
        return delSchedule(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/schedule/export', {
        ...this.queryParams
      }, `schedule_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

