package com.bits.cpad.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bits.cpad.dto.PlayerDTO;
import com.bits.cpad.dto.TeamDTO;
import com.bits.cpad.dto.UserDTO;
import com.bits.cpad.entity.Team;
import com.bits.cpad.entity.TeamMembers;
import com.bits.cpad.entity.User;

public class DTOToEntityMapper {

//	{id=116212339828922220251, name=JAYANTA H R, 
//	email=2021mt93120@wilp.bits-pilani.ac.in, 
//			photoUrl=https://lh3.googleusercontent.com/a/AATXAJzgx0CSF8MUu_GtoT94TK-IYhd2cdo9uEV8gjMS=s96-c, 
//				firstName=JAYANTA H R, lastName=., response={token_type=Bearer, access_token=ya29.A0ARrdaM8N3xrzTzSpJZ_wQgyo2GEY_iS3jCkkiyBLJ4Q1ZYCHnMcgk5klZf6c27tSBxbol-itndbZn1p3kBXV2mMhncGgpmbXqaEBbaF_fHUCJob-GS0JC2M4zpWAJp0z5Mxc-_Bw9PdJGkp6gd-r9Fpfmkcd6iY, scope=email profile openid https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile, login_hint=AJDLj6JUa8yxXrhHdWRHIV0S13cAoWk2oagx-Zya_BUv680IeReVHHylmcUhbtdF9xOAJQdf1JI9NwA8arwZ0jK10Tn2hpJ4iA, expires_in=3599, id_token=eyJhbGciOiJSUzI1NiIsImtpZCI6Ijg2MTY0OWU0NTAzMTUzODNmNmI5ZDUxMGI3Y2Q0ZTkyMjZjM2NkODgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiNzMxNTQ2ODM1MTA1LWc4OHA2OHFjYmI1Yzg1NzlrZWJlZWVjaWthbmhzNTNuLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiNzMxNTQ2ODM1MTA1LWc4OHA2OHFjYmI1Yzg1NzlrZWJlZWVjaWthbmhzNTNuLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTE2MjEyMzM5ODI4OTIyMjIwMjUxIiwiaGQiOiJ3aWxwLmJpdHMtcGlsYW5pLmFjLmluIiwiZW1haWwiOiIyMDIxbXQ5MzEyMEB3aWxwLmJpdHMtcGlsYW5pLmFjLmluIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF0X2hhc2giOiJ1NDF1cElKZVdNNm14cmFhYlVaekJRIiwibmFtZSI6IkpBWUFOVEEgSCBSIiwicGljdHVyZSI6Imh0dHBzOi8vbGgzLmdvb2dsZXVzZXJjb250ZW50LmNvbS9hL0FBVFhBSnpneDBDU0Y4TVV1X0d0b1Q5NFRLLUlZaGQyY2RvOXVFVjhnak1TPXM5Ni1jIiwiZ2l2ZW5fbmFtZSI6IkpBWUFOVEEgSCBSIiwiZmFtaWx5X25hbWUiOiIuIiwibG9jYWxlIjoiZW4iLCJpYXQiOjE2NTEzMTUyMjYsImV4cCI6MTY1MTMxODgyNiwianRpIjoiNzY1ZjBlNTkzNTBjNzM5NWIzZGIzODZjZjUyZjBhNmU5YWE5ODRlMSJ9.Udsi2AUBGA0LJDrufawT0IpWHElbfY20AKxyRi5rmGK1RRJpn4Rtco9yBkRbAhIlYeV_tGyF9OEHXHuc24fKh9mH8-kFMaQEKYgVn_3ge4zqjfYClyd9isNi4xMFJUPxQZmShWANlV_A3s0Ox5mMXxzvLnp7xf9PnfUWDojMVS8A3NoIZ6eFn-ZwC7YwwzJYyiv6xAbMyx8XoSxfedv2bdgjcJhfSFwRPVbcS0a43rhVgYAybpK4Hc2yNqkkt3rpUVof8iuTYe0N0k1ad6gDLzjoilITWbEbwKAW9YMFDlhZT7LVvZPaDXYNOrFSe5Z0gtT6Xeqpi7fctCLTSjpiFA, session_state={extraQueryParams={authuser=0}}, first_issued_at=1651315225545, expires_at=1651318824545, idpId=google}, authToken=ya29.A0ARrdaM8N3xrzTzSpJZ_wQgyo2GEY_iS3jCkkiyBLJ4Q1ZYCHnMcgk5klZf6c27tSBxbol-itndbZn1p3kBXV2mMhncGgpmbXqaEBbaF_fHUCJob-GS0JC2M4zpWAJp0z5Mxc-_Bw9PdJGkp6gd-r9Fpfmkcd6iY, idToken=eyJhbGciOiJSUzI1NiIsImtpZCI6Ijg2MTY0OWU0NTAzMTUzODNmNmI5ZDUxMGI3Y2Q0ZTkyMjZjM2NkODgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiNzMxNTQ2ODM1MTA1LWc4OHA2OHFjYmI1Yzg1NzlrZWJlZWVjaWthbmhzNTNuLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiNzMxNTQ2ODM1MTA1LWc4OHA2OHFjYmI1Yzg1NzlrZWJlZWVjaWthbmhzNTNuLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTE2MjEyMzM5ODI4OTIyMjIwMjUxIiwiaGQiOiJ3aWxwLmJpdHMtcGlsYW5pLmFjLmluIiwiZW1haWwiOiIyMDIxbXQ5MzEyMEB3aWxwLmJpdHMtcGlsYW5pLmFjLmluIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF0X2hhc2giOiJ1NDF1cElKZVdNNm14cmFhYlVaekJRIiwibmFtZSI6IkpBWUFOVEEgSCBSIiwicGljdHVyZSI6Imh0dHBzOi8vbGgzLmdvb2dsZXVzZXJjb250ZW50LmNvbS9hL0FBVFhBSnpneDBDU0Y4TVV1X0d0b1Q5NFRLLUlZaGQyY2RvOXVFVjhnak1TPXM5Ni1jIiwiZ2l2ZW5fbmFtZSI6IkpBWUFOVEEgSCBSIiwiZmFtaWx5X25hbWUiOiIuIiwibG9jYWxlIjoiZW4iLCJpYXQiOjE2NTEzMTUyMjYsImV4cCI6MTY1MTMxODgyNiwianRpIjoiNzY1ZjBlNTkzNTBjNzM5NWIzZGIzODZjZjUyZjBhNmU5YWE5ODRlMSJ9.Udsi2AUBGA0LJDrufawT0IpWHElbfY20AKxyRi5rmGK1RRJpn4Rtco9yBkRbAhIlYeV_tGyF9OEHXHuc24fKh9mH8-kFMaQEKYgVn_3ge4zqjfYClyd9isNi4xMFJUPxQZmShWANlV_A3s0Ox5mMXxzvLnp7xf9PnfUWDojMVS8A3NoIZ6eFn-ZwC7YwwzJYyiv6xAbMyx8XoSxfedv2bdgjcJhfSFwRPVbcS0a43rhVgYAybpK4Hc2yNqkkt3rpUVof8iuTYe0N0k1ad6gDLzjoilITWbEbwKAW9YMFDlhZT7LVvZPaDXYNOrFSe5Z0gtT6Xeqpi7fctCLTSjpiFA, 
//	provider=GOOGLE}
	
	public static User getUser(Map<?,?> userMap) {
		User user = new User();
		user.setUserFName(userMap.get("firstName").toString());
		user.setUserLName(userMap.get("lastName").toString());
		user.setEmail(userMap.get("email").toString());
		
		return user;
	}

	public static Team getTeam(TeamDTO teamDTO) {
		Team team = new Team();
		
		team.setId(teamDTO.getId());
		team.setLocation(teamDTO.getLocation());
		team.setOwner(getUser(teamDTO.getOwner()));
		team.setSize(teamDTO.getTeamSize());
		team.setTeamIdentifier(teamDTO.getIdentifier());
		team.setCaptain(getUser(teamDTO.getCaptain()));
		team.setTeamMembers(getTeamMembers(teamDTO.getPlayers()));
		team.setTeamName(teamDTO.getName());
		return team;
	}

	private static List<TeamMembers> getTeamMembers(List<PlayerDTO> players) {
		List<TeamMembers> members = players.stream().map(player -> {
			TeamMembers member = new TeamMembers();
			member.setId(player.getTeamMemberId());
			member.setPlayerStatus(player.getPlayerStatus());
			member.setPlayer(getUser(player));
			return member;
		}).collect(Collectors.toList());
		
		return members;
	}

	private static User getUser(UserDTO owner) {
		User user = new User();
		user.setId(owner.getId());
		return user;
	}

	public static User getUser(PlayerDTO player) {
		User user = new User();
		user.setId(player.getId());
		return user;
	}
}
