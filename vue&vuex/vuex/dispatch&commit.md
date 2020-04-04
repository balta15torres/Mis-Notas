# Dispatch & Commit
```
const store = new Vuex.Store({
  modules: {
    account: {
      // activamos todas las propiedades del módulo con namespaced
      namespaced: true,
      // propiedades activas del módulo por el namespaced
      state: {  }, // El state del módulo ya está anidado y no se ve afectado por la opción de espacio de nombres(Namespacing)
      getters: {
        isAdmin () {  } // --> getters['isAdmin']
      },
      actions: {
        login () {  }   // --> dispatch('login')
      },
      mutations: {
        login () {  }   // --> commit('login')
      },

    }
  }
})

const store = new Vuex.Store({
  modules: {
    myPage: {
      state: {  },
      actions: {
           // --> dispatch('account/login',null,{root:true})
      },
      mutations: {
           // --> commit('account/login',null,{root:true})
      },
      getters: {
           // --> getters['account/profile']
      }
    },
  }
}
```
Para 'dispatch'acciones o 'commit'mutaciones que son activos globales de 'Namespacing'; 

- primer parametro(prefijo'donde esta'/'nombre de la action')
- segundo parametro(si no pasamos datos, le pasaremos 'null')
- tercer parametro({root:true})
