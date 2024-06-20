import { PG } from "@/app/components/common/enums/PG";
import { Http2ServerResponse } from "http2";
import { JwtPayload, jwtDecode } from "jwt-decode";
import Link from "next/link"
import { parseCookies } from "nookies";

interface ILinkButton {
    title: string,
    path: string
}



export default function Linkbutton({ title, path }: ILinkButton) {
    return (
        <li >
            <Link href={`${path}`}
                className="block px-6 py-3 text-lm
      text-gray-700 hover:bg-gray-100
       dark:hover:bg-gray-600 dark:text-gray-200
        dark:hover:text-white">{title}</Link></li>
    )
}

export const pages = [
    // { id: 1, title: '회원가입', path: `${PG.USER}/join` },
    // { id: 2, title: '로그인', path: '/' },
    { id: 3, title: '계좌생성', path: `${PG.ACCOUNT}/create` },
    { id: 4, title: '계좌목록', path: `${PG.ACCOUNT}/list` },
    // { id: 5, title: '거래내역', path: `${PG.TRADE}/list` },
    // { id: 6, title: '마이페이지', path: `${PG.USER}/detail/${parseCookies()?.accessToken ?  jwtDecode<any>(parseCookies()?.accessToken).userId : 0 }` }
]


export const settings = [
    'Profile', 'Account', 'Dashboard', 'Logout'];