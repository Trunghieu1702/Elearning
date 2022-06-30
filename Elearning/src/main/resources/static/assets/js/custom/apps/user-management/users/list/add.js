"use strict";
var KTUsersAddUser=function(){
    const t=document.getElementById("kt_modal_add_user"),
    e=t.querySelector("#kt_modal_add_user_form"),
    n=new bootstrap.Modal(t);
    return{init:function(){
        (()=>{
            var o=FormValidation.formValidation(e,{
                fields:{
                    name:{validators:{notEmpty:{message:"Họ Tên không thể để trống!!"}}},
                    email:{validators:{notEmpty:{message:"Email không thể để trống!!"}}},
                     code:{validators:{notEmpty:{message:"Tên đăng nhập không thể để trống!!"}}},
                    birthday:{validators:{notEmpty:{message:"Ngày Sinh không thể để trống!!"}}},
                    sex:{validators:{notEmpty:{message:"Giới tính không thể để trống!!"}}},
                    address:{validators:{
                    			notEmpty:{message:"Địa Chỉ không thể để trống!!"},
                    			stringLength:{
        							min: 1,
        							max: 400,
        							message: 'Địa chỉ bao gồm từ 1 đến 40 ký tự!!'}
                    				
                    			}},
                    phone_number:{validators:{notEmpty:{message:"Số Điện Thoại nhập không thể để trống!!"}}},
                    start_date:{validators:{notEmpty:{message:"Ngày Bắt Đầu không thể để trống!!"}}},
                    },
                    plugins:{trigger:new FormValidation.plugins.Trigger,bootstrap:new FormValidation.plugins.Bootstrap5({rowSelector:".fv-row",eleInvalidClass:"",eleValidClass:""})}});
                    const i=t.querySelector('[data-kt-users-modal-action="submit"]');
                    i.addEventListener("click",(t=>{
                        t.preventDefault()
                        ,o&&o.validate().
                        then((function(t){
                            console.log("validated!"),
                            "Valid"==t?(i.setAttribute("data-kt-indicator","on"),
                            i.disabled=!0,setTimeout((function(){
                            	e.submit(),
                                i.removeAttribute("data-kt-indicator"),
                                i.disabled=!1,
                                Swal.fire({text:"Lưu Thành Công!",
                                icon:"success",buttonsStyling:!1,
                                confirmButtonText:"Ok!",
                                customClass:{confirmButton:"btn btn-primary"}}).
                                then((function(t){t.isConfirmed&&n.hide()}))}),2e3)):
                                Swal.fire({text:"Sorry, looks like there are some errors detected, please try again.",
                                icon:"error",buttonsStyling:!1,confirmButtonText:"Ok, got it!",
                                customClass:{confirmButton:"btn btn-primary"}})}))})),
                                t.querySelector('[data-kt-users-modal-action="cancel"]').
                                addEventListener("click",(t=>{t.preventDefault(),
                                    Swal.fire({
                                        text:"Bạn có muốn hủy nó?",
                                        icon:"warning",
                                        showCancelButton:!0,
                                        buttonsStyling:!1,
                                        confirmButtonText:"Có ,hủy nó!",
                                        cancelButtonText:"Không, quay Trở lại",
                                        customClass:{
                                            confirmButton:"btn btn-primary",
                                            cancelButton:"btn btn-active-light"}})
                                        .then((function(t){
                                            t.value?(e.reset(),n.hide())
                                            :"cancel"===t.dismiss&&Swal.fire({
                                                text:"Your form has not been cancelled!.",
                                                icon:"error",
                                                buttonsStyling:!1,
                                                confirmButtonText:"Ok, got it!",
                                                customClass:{confirmButton:"btn btn-primary"}})}))})),
                                                t.querySelector('[data-kt-users-modal-action="close"]').addEventListener("click",(t=>{
                                                    t.preventDefault(),
                                                    Swal.fire({
                                                        text:"Are you sure you would like to cancel?",
                                                        icon:"warning",
                                                        showCancelButton:!0,
                                                        buttonsStyling:!1,
                                                        confirmButtonText:"Yes, cancel it!",
                                                        cancelButtonText:"No, return",
                                                        customClass:{
                                                            confirmButton:"btn btn-primary",
                                                            cancelButton:"btn btn-active-light"}})
                                                            .then((function(t){
                                                                t.value?
                                                                (e.reset(),n.hide())
                                                                :"cancel"===t.dismiss&&Swal.fire({
                                                                    text:"Your form has not been cancelled!.",
                                                                    icon:"error",
                                                                    buttonsStyling:!1,
                                                                    confirmButtonText:"Ok, got it!",
                                                                    customClass:{confirmButton:"btn btn-primary"}})}))}))})()}}}();
KTUtil.onDOMContentLoaded((function(){KTUsersAddUser.init()}));