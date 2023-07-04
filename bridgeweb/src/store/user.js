
import router from "../router";
export default {
    state: {
        id: "",
        username: "",
        photo: "",
        token: "",
        is_login: false,
        pulling_info: true,
    },
    actions: {
        logout() {
            this.account=""
            this.is_login=false
            this.username=""
            this.unit_no = ""
            this.unit_name = ''
            sessionStorage.removeItem("is_login")
            router.push('login')
        }
    }
}
