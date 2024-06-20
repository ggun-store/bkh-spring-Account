import { createAsyncThunk } from "@reduxjs/toolkit";
import { createAccountAPI, depositAPI, findAllAccountsAPI } from "./account-api";
import { IAccount } from "../model/account";

export const findAllAccounts : any = createAsyncThunk(
    'accounts/findAllaccounts',
     async (id:number)=>{
    const data:any = await findAllAccountsAPI(id);
    return data
})

export const createAccount:any = createAsyncThunk(
    'accounts/createAccount',
    async (dto:IAccount)=>{
    const data : any =await createAccountAPI(dto);
    console.log('서비스 확인'+JSON.stringify(dto))
    return data
    })

export const deposit:any = createAsyncThunk(
    'accounts/deposit',
    async (dto:IAccount)=>{
    const data : any =await depositAPI(dto);
    console.log('서비스 확인'+JSON.stringify(dto))
    return data
    })