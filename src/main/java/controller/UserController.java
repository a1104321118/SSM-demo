package controller;

import javax.servlet.http.HttpServletResponse;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.UserService;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="login")
	@ResponseBody
	public JSONObject loginController(@RequestParam String username,@RequestParam String password,HttpServletResponse response){
		
		JSONObject json = new JSONObject();
		
		User loginUser = userService.getUserByUsername(username);
		if(null == loginUser){
			json.put("msg", "登录失败");
			return json;
		}
		if(!loginUser.getPassword().equals(password)){
			json.put("msg", "登陆失败");
			return json;
		}
		json.put("msg", "登录成功");
		
		return json;
	}
	
	

}
