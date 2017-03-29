<template>
        <!--工具条-->
    <el-row>
        <el-col :span="24" class="toolbar">
            <el-form :inline="true" :model="formInline" class="demo-form-inline">
                <el-form-item>
                    <el-input v-model="ip" placeholder="服务器地址"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button>诊断</el-button>
                </el-form-item>
            </el-form>
        </el-col>
        <el-input type="textarea" :rows="10" ></el-input>
    </el-row>
</template>
<script>
    export default {
        data () {
            return {
                ip:''
            };
        },
        methods:{

        }
    }

</script>
<style>

</style>