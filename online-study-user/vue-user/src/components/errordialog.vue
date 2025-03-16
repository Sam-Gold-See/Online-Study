<script setup lang="ts">

import { useErrorStore } from '@/stores/errordialog' 
const errorStore=useErrorStore()


</script>

<template>
    <div v-if="errorStore.see">
        <el-dialog
            title="提示信息"
            width="500"
        >
            <span>{{ errorStore.msg }}</span>
            <template #footer>
                <div class="dialog-footer">
                    <el-button type="primary" @click="errorStore.see=false;errorStore.msg=''">
                        确认
                    </el-button>
                </div>
            </template>
        </el-dialog>
    </div>
</template>