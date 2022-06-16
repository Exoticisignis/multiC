import { createWebHistory, createRouter } from "vue-router";

import Films from "./pages/home/Films";


import Film from "./pages/film/Film";
import Bilet from "./pages/film/Bilet";



const routes = [
  { path: "/", name: 'Films', component: Films },


  { path: "/films/:id", name: 'Film', component: Film },
  { path: "/films/:id/:id2", name: 'Bilet', component: Bilet },

];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
