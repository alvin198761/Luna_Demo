<template>
    <el-row class="content">
        <el-col :span="6" style="height: 100%">
            <el-tree style="height: 100%" :data="data" :props="defaultProps" @node-click="handleNodeClick"></el-tree>
        </el-col>
        <el-col :span="18">
            <div  style="width: 98% ;padding-left:10px; ">
                <el-col :span="8" style="padding-top: 5px">
                    <el-input size="small"
                            placeholder="根据名称搜索"
                            icon="search"
                            v-model="filterStr" >
                    </el-input></el-col>
                <el-col :span="16" style="padding-top: 5px">

                    <el-button-group>
                        <el-button size="small"  icon="edit"></el-button>
                        <el-button size="small"   icon="share"></el-button>
                        <el-button size="small"  icon="delete"></el-button>
                    </el-button-group>
                </el-col>
                <el-table
                        :data="tableData"
                        highlight-current-row
                        @current-change="handleCurrentChange"
                        style="width: 100%; ">
                    <el-table-column
                            type="index"
                            width="50">
                    </el-table-column>
                    <el-table-column
                            property="date"
                            label="日期"
                            width="120">
                    </el-table-column>
                    <el-table-column
                            property="name"
                            label="姓名"
                            width="120">
                    </el-table-column>
                    <el-table-column
                            property="address"
                            label="地址">
                    </el-table-column>
                </el-table>
            </div>
        </el-col>
    </el-row>
</template>
<script>
    export default {
        data(){
            return {
                tableData: [{
                    index:1,
                    date: '2016-05-02',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    index:2,
                    date: '2016-05-04',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1517 弄'
                }, {
                    index:3,
                    date: '2016-05-01',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1519 弄'
                }, {
                    index:3,
                    date: '2016-05-03',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1516 弄'
                }],
                currentRow: null,
                data: [{
                    label: '一级 1',
                    children: [{
                        label: '二级 1-1'
                    }]
                }, {
                    label: '一级 2',
                    children: [{
                        label: '二级 2-1'
                    }, {
                        label: '二级 2-2'
                    }]
                }, {
                    label: '一级 3',
                    children: [{
                        label: '二级 3-1'
                    }, {
                        label: '二级 3-2'
                    }]
                }],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                },
                filterStr:''

            };
        },

        methods: {
            handleNodeClick(){

            },
            handleCurrentChange(row){

            }

        }

    }
</script>
<style>
    .content {
        top: 50px;
        bottom: 25px;
        position: absolute;
        width: 98%;
        background: white;
    }

</style>