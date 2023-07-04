import {createRouter, createWebHistory} from "vue-router"


const routes = [
    {
        path:'/',
        redirect:'/home'
    },
    {
        path:'/index',
        redirect:'/home'
    },
    {
        path: '/index',
        meta: {
            author:false,    
        },
        component: () => import( '../views/index.vue'),

        children: [
            {
                path:'/home',
                name:'home',
                meta: {
                    author:false,
                },
                component: () => import( '../views/HomeView.vue'),
            },
            {
                path:'/basicinfo',
                name:'basicinfo',
                meta: {
                    author:false,
                },
                component: () => import('../views/BasicInfo.vue'),
            },
            {
                path:'/initexam',
                name:'initexam',
                meta: {
                author:false,
                },
                component: () => import('../views/InitExam.vue'),
            },
            {
                path:'/regularexam',
                name:'regularexam',
                meta: {
                    author:false,
                },
                component: () => import('../views/RegularExam.vue'),
            },
        ]
    },
    {
        path: '/admin',
        name: 'admin',
        meta: {
            author: false
        },
        component: () => import('../views/AdminIndex.vue'),
        children: [
            {
                path: '/adminhome',
                name:'adminhome',
                meta: {
                    author:false,
                },
                component: () => import('../views/AdminHome.vue'),
            },
            {
                path: '/route',
                name:'route',
                meta: {
                    author:false,
                },
                component: () => import('../views/Route.vue'),
            },
            {
                path: '/bty',
                name:'bty',
                meta: {
                    author:false,
                },
                component: () => import('../views/BriType.vue'),
            },
            {
                path: '/unit',
                name:'unit',
                meta: {
                    author:false,
                },
                component: () => import('../views/Unit.vue'),
            },
            {
                path: '/part',
                name:'part',
                meta: {
                    author:false,
                },
                component: () => import('../views/PartMg.vue'),
            },
            {
                path: '/assunit',
                name:'assunit',
                meta: {
                    author:false,
                },
                component: () => import('../views/AssunitMg.vue'),
            },
        ]
    },
    {
        path: '/login',
        name:'login',
        meta: {
            author:false,
        },
        component: () => import(/* webpackChunkName: "login" */ '../views/UserLogin.vue'),
        
    },
    {
        path: '/register',
        name:'register',
        meta: {
            author:false,
        },
        component: () => import(/* webpackChunkName: "login" */ '../views/UserRegister.vue'),
        
    },
    {
        path: '/notfound',
        name:'notfound',
        meta: {
            author:false,
        },
        component: () => import(/* webpackChunkName: "404" */ '../views/404.vue'),
        
    },
    {
        path: "/:catchAll(.*)",
        redirect: "/notfound"
    }

];

const router = createRouter({
    history : createWebHistory(),
    routes,
})

router.beforeEach((to, _form, next) => {
    if (to.meta.author && !sessionStorage.getItem("is_login")) {
        next({name:'login'})
    } else {
        next()
    }
})

export default router