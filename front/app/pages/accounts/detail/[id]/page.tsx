'use client'

import { IAccount } from "@/app/components/account/model/account";
import { deposit, findByAccount } from "@/app/components/account/service/account-service";
import { IUser } from "@/app/components/users/model/user.model";
import { findUserById } from "@/app/components/users/service/user-service";
import { getUserById } from "@/app/components/users/service/user-slice";
import axios from "axios";
import { jwtDecode } from "jwt-decode";
import { useRouter } from "next/navigation";
import { parseCookies } from "nookies";
import { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { useDispatch } from "react-redux";




export default function AccountDetail({ params }: any) {
    const router = useRouter();
    const dispatch = useDispatch();
    const [amount,setAmount] = useState(0);
    const user:IUser =useSelector(getUserById)

    const onSubmit = (data: any) => {
      window.IMP.init('imp78657013'); // Iamport 가맹점 식별코드

      window.IMP.request_pay(
        {
          pg: 'html5_inicis',
          pay_method: 'card',
          merchant_uid: new Date().getTime().toString(), //  주문 번호
          name: '테스트 상품',
          amount: amount, // Use the state variable for amount
          buyer_email: 'test@naver.com',
          buyer_name: user.name,
          buyer_tel: user.phone
        },
        async (rsp: any) => {
          try {
            if (rsp.success) {
              console.log(rsp.imp_uid);
  
              const token = parseCookies().accessToken; 
  
              const { data } = await axios.post(
                `http://localhost:8080/api/accounts/verifyIamport/${rsp.imp_uid}`,
                {},
                {
                  headers: {
                    Authorization: `Bearer ${token}`
                  }
                }
              );
              console.log(rsp.imp_uid);
              if (rsp.paid_amount === data.response.amount) {  
                console.log(data.response);
                const paymentData = {    // 내 db 저장 값 
                  balance : data.response.amount,
                  id : params.id,
                  paymentUid: rsp.imp_uid,
                  tradeType : "입금",

                };
                dispatch(deposit(paymentData))
                .then((res: any) => {
                  console.log('res.message '+ JSON.stringify(res.payload.message))
                  router.refresh()
                })
                console.log('data.response.amount:', data.response.amount);
                alert('결제 성공');
              } else {
                alert('결제 실패');
              }
            } else {
              alert('결제 실패');
            }
          } catch (error) {
            console.error('Error while verifying payment:', error);
            alert('결제 실패');
          }
        }
      );
    }

    useEffect(() => {
      dispatch(findUserById(parseCookies()?.accessToken ? jwtDecode<any>(parseCookies().accessToken).userId : 0))
      dispatch(findByAccount(parseCookies()?.accessToken ? jwtDecode<any>(parseCookies().accessToken).userId : 0))
      
      const jquery = document.createElement('script');
      jquery.src = 'http://code.jquery.com/jquery-1.12.4.min.js';
      const iamport = document.createElement('script');
      iamport.src = 'http://cdn.iamport.kr/js/iamport.payment-1.1.7.js';
      document.head.appendChild(jquery);
      document.head.appendChild(iamport);
      return () => {
        document.head.removeChild(jquery);
        document.head.removeChild(iamport);
      };
    }, []);
  



    return (<>
<div className="w-full h-full max-w-[1200px] mx-auto">
      <div className="px-[32px] text-center">
        <div className="text-center text-black-500 text-[64px] font-bold font-['Inter'] mb-[32px]">계좌 정보</div>
        <div>충전금액 입력</div>
        <input type="prdtName" onChange={(e) => setAmount(parseInt(e.target.value, 10))}  id="prdtName"  
                className="block w-100 p-4 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 
                focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                placeholder="충전금액을 입력하세요" required />
        <div className="text-black-400 flex-center text-[32px] font-normal font-['Newsreader'] my-[48px] w-full">
          <button onClick={onSubmit} className="h-[72px] w-[127px] bg-violet-500 rounded-lg  text-center ml-[16px]
           text-white text-2xl font-['Inter']" type='button' >총알 충전</button>
        </div>
        
        <div className="w-full bg-stone-50 rounded-3xl border-2
         border-neutral-200 p-[48px] h-auto"  >
          <div className="text-center text-black-500 text-[30px] font-bold font-['Inter'] mb-[15px]">계좌 내역</div>
{/* 
          <form onSubmit={handleSubmit(onSubmit)} className="max-w-md mx-auto mb-[15px]">
            <label htmlFor="text" className="mb-2 text-sm font-medium text-gray-900 sr-only dark:text-white">Search</label>
            <div className="relative">
              <div className="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
                <svg className="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                  <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
                </svg>
              </div>
              <input type="prdtName" id="prdtName"   {...register('prdtName', { required: true })} 
                className="block w-full p-4 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                placeholder="검색 종목을 입력하세요" required />
              <button type="submit" className="text-white absolute end-2.5 bottom-2.5 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Search</button>
            </div>
          </form>

           <div className='h-auto text-center'>
            {tradeList && <DataGrid
              rows={tradeList}
              columns={tradesColums()}
              pageSizeOptions={[5, 10, 20]}
              checkboxSelection
            />}
          </div> */}
        </div>
      </div>
    </div>

    </>)

}