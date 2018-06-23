package rs.ftn.xws.booking.dto;

public class ModifyDTO {
	private String oldName;
	private String newName;
	
	public ModifyDTO() {
		
	}
	
	public ModifyDTO(String oldName, String newName) {
		this.oldName = oldName;
		this.newName = newName;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}
	
	
}
