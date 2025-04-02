<script setup lang="ts">
defineProps(['message'])
</script>

<template>
    <div>
        <div class="container">
            {{ message }}
        </div>
    </div>
</template>

<style scoped>
.container{
    width:400px;
    height:150px;
    line-height: 150px;
    position: absolute;
    left:650px;
    top:310px;
    color:#67C23A;
    text-align: center;
    font-size:22px;
    background-color: white;
    border-radius: 10px;
    box-shadow: 1px 1px 1px 1px gray;
}
</style>