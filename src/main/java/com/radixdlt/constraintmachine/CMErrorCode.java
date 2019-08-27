package com.radixdlt.constraintmachine;

/**
 * Error codes from Constraint Machine validation.
 * TODO: add numeric codes
 */
public enum CMErrorCode {
	HOOK_ERROR("Hook error"),
	MISSING_PARTICLE_GROUP("Missing particle group"),
	INTERNAL_SPIN_CONFLICT("Internal spin conflict"),
	UNKNOWN_PARTICLE("Unknown particle"),
	PARTICLE_REGISTER_SPIN_CLASH("Particle spin clashes with current particle in register"),
	MISSING_TRANSITION_PROCEDURE("Transition procedure missing"),
	UNEQUAL_INPUT_OUTPUT("Inputs and outputs do not match"),
	WITNESS_ERROR("Witness error"),
	TRANSITION_ERROR("Transition error");

	private final String description;

	CMErrorCode(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
