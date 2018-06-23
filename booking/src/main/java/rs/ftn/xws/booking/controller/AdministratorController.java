package rs.ftn.xws.booking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.ftn.xws.booking.dto.BonusDto;
import rs.ftn.xws.booking.dto.ModifyDTO;
import rs.ftn.xws.booking.dto.ProfileDto;
import rs.ftn.xws.booking.persistence.domain.AccomodationType;
import rs.ftn.xws.booking.persistence.domain.AdditionalService;
import rs.ftn.xws.booking.persistence.domain.Category;
import rs.ftn.xws.booking.persistence.domain.Role;
import rs.ftn.xws.booking.persistence.domain.RoleName;
import rs.ftn.xws.booking.persistence.domain.User;
import rs.ftn.xws.booking.security.JwtTokenProvider;
import rs.ftn.xws.booking.service.DomainUserDetailsService;
import rs.ftn.xws.booking.service.SearchFilterService;
import rs.ftn.xws.booking.service.TokenService;

@RestController
@RequestMapping("/api/admin")
public class AdministratorController {
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
    
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private DomainUserDetailsService domainUserDetailsService;
    
    @Autowired
	private SearchFilterService searchFilterService;
    
    @PostMapping("/addType")
	@PreAuthorize("hasRole('ADMIN')")
	public AccomodationType postType(@RequestBody BonusDto type) {
		return searchFilterService.addType(type.getName());
	}
	
	@PostMapping("/addCategory")
	@PreAuthorize("hasRole('ADMIN')")
	public Category postCategory(@RequestBody BonusDto category) {
		return searchFilterService.addCategory(category.getName());
	}
	
	@PostMapping("/addService")
	@PreAuthorize("hasRole('ADMIN')")
	public AdditionalService postService(@RequestBody BonusDto name) {
		return searchFilterService.addAdditionalService(name.getName());
	}
	
	@PostMapping("/modifyService")
	@PreAuthorize("hasRole('ADMIN')")
	public AdditionalService modifyService(@RequestBody ModifyDTO name) {
		return searchFilterService.modifyService(name.getOldName(),name.getNewName());
	}
	
	@PostMapping("/modifyType")
	@PreAuthorize("hasRole('ADMIN')")
	public AccomodationType modifyType(@RequestBody ModifyDTO name) {
		return searchFilterService.modifyType(name.getOldName(),name.getNewName());
	}
	
	@PostMapping("/modifyCategory")
	@PreAuthorize("hasRole('ADMIN')")
	public Category modifyCategory(@RequestBody ModifyDTO name) {
		return searchFilterService.modifyCategory(name.getOldName(),name.getNewName());
	}
	
	

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getClients")
    public List<ProfileDto> getClients(){
    	List<ProfileDto> foundClients = new ArrayList<ProfileDto>();
    	List<User> clients = domainUserDetailsService.findAllUsers();
    	
    	for (User client : clients) {
    		
			foundClients.add(new ProfileDto(client.getEmail(), domainUserDetailsService.getUserAuthorities(client),client.isNonLocked()));
		}
    	return foundClients;
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getAgents")
    public List<ProfileDto> getAgents(){
    	List<ProfileDto> foundClients = new ArrayList<ProfileDto>();
    	List<User> clients = domainUserDetailsService.findAllUsers();
    	
    	for (User client : clients) {
    		Set<Role> roles = client.getRoles();
    		boolean yes= false;
    		for(Role rola : roles) {
    			if (rola.getName().equals(RoleName.ROLE_AGENT)) {
    				yes=true;
    				break;
    			}
    		}
    		if(!yes)
    			continue;
			foundClients.add(new ProfileDto(client.getEmail(), domainUserDetailsService.getUserAuthorities(client),client.isNonLocked()));
		}
    	return foundClients;
    }
    
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/changeLockStatusTrue")
    public ProfileDto lockUser(@RequestBody ProfileDto user) {
    	if (domainUserDetailsService.findByEmail(user.getUsername())==null )
    		return null;
    	User user1 = domainUserDetailsService.findByEmail(user.getUsername());
    	domainUserDetailsService.changeUserNonLockStatusTrue(user1);
    	return user;
    	
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/changeLockStatusFalse")
    public ProfileDto unLockUser(@RequestBody ProfileDto user) {
    	if (domainUserDetailsService.findByEmail(user.getUsername())==null )
    		return null;
    	User user1 = domainUserDetailsService.findByEmail(user.getUsername());
    	domainUserDetailsService.changeUserNonLockStatusFalse(user1);
    	return user;
    	
    }
    
    
    
    
    

}
