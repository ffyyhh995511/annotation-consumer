package org.fyh.annotation.consumer.service;

import java.util.List;

import org.boot.tech.core.model.Game;
import org.boot.tech.core.service.GameService;
import org.fyh.annotation.provider.service.StudentService;
import org.fyh.annotation.provider.service.TeacherService;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

@Service
public class ConsumerService {
	
	@Reference
	StudentService studentService;
	
	@Reference
	TeacherService teacherService;

	@Reference
	GameService gameService;
	/**
	 * 测试调用dubbo provider 的接口
	 */
	public void testRemoteDubboTest(){
		System.out.println("3333");
		System.out.println(studentService.getStudent());
		System.out.println(teacherService.getTeacherName());
		List<Game> remoteQueryAll = gameService.remoteQueryAll();
		for (Game game : remoteQueryAll) {
			System.out.println(game.getId());
		}
	}
	
}
