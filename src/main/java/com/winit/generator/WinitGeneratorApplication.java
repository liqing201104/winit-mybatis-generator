package com.winit.generator;

import com.winit.generator.framework.Application;
import com.winit.generator.task.CombineInfoTask;
import com.winit.generator.task.DaoImplTask;
import com.winit.generator.task.DaoInterfaceTask;
import com.winit.generator.task.EntityTask;
import com.winit.generator.task.InitTask;
import com.winit.generator.task.MapperTask;
import com.winit.generator.task.VoTask;

/**
 * 
 * 程序入口
 * 
 * @version 
 * <pre>
 * Author	Version		Date		Changes
 * qiyongkang 	1.0  		2017年4月25日 	Created
 *
 * </pre>
 * @since 1.
 */
public class WinitGeneratorApplication {
    public static void main(String[] args) {
        //程序入口
        Application application = new Application(WinitGeneratorApplication.class.getSimpleName());
        application.parseArgs(args);
        application.setApplicationName(WinitGeneratorApplication.class.getName());
        application.addApplicationTask(InitTask.class)
        .addApplicationTask(CombineInfoTask.class)
        .addApplicationTask(EntityTask.class)
        .addApplicationTask(MapperTask.class)
        .addApplicationTask(DaoInterfaceTask.class)
        .addApplicationTask(DaoImplTask.class)
        .addApplicationTask(VoTask.class)
        .work();
    }
}
