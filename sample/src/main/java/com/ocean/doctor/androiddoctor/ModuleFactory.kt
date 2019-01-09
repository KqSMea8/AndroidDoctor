package com.ocean.doctor.androiddoctor

/**
 * Created by oceanlong on 2018/11/15.
 */
class ModuleFactory{
    companion object {
        var moduleList:MutableList<ModuleBean> = ArrayList()
        fun getModules():List<ModuleBean>{

            val bean = ModuleBean()
            bean.name = "Manifest"
            bean.func = "minifestdoctor"
            moduleList.add(bean)

            val soBean = ModuleBean()
            soBean.name = "so load"
            soBean.func = "soloaddemo"
            moduleList.add(soBean)
            return moduleList
        }
    }
}