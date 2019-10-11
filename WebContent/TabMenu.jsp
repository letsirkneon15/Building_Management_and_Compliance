    	<ul class="nav nav-tabs">
    		<c:if test="${not empty genInfoTab.tabDsp}">
    		<c:set var="liClass" value="${'active'}"/>	
  				<li class="${liClass }"><a data-toggle="tab" href="#GenInfo">
  				<h5 class="m-0 font-weight-bold text-primary">General <br> Information</h5></a></li>
  			</c:if>
  			
  			<c:if test="${not empty contactsTab.tabDsp}">
  				<c:choose>
  					<c:when test="${empty liClass}">
  						<li class="active">
  						<c:set var="liClass" value="${'active'}"/>
  					</c:when>
  					<c:otherwise>
  						<li>
  					</c:otherwise>
  				</c:choose>
  				<a data-toggle="tab" href="#Contacts">
  				<h5 class="m-0 font-weight-bold text-primary">Contacts <br><br></h5></a></li>
  			</c:if>
  			
  			<c:if test="${not empty wofTab.tabDsp}">
   				<c:choose>
  					<c:when test="${empty liClass}">
  						<li class="active">
  						<c:set var="liClass" value="${'active'}"/>
  					</c:when>
  					<c:otherwise>
  						<li>
  					</c:otherwise>
  				</c:choose>
  				<a data-toggle="tab" href="#WOF">
  				<h5 class="m-0 font-weight-bold text-primary">WOF <br><br></h5></a></li>
  			</c:if>
  			
  			<c:if test="${not empty consentTab.tabDsp}">
  			  	<c:choose>
  					<c:when test="${empty liClass}">
  						<li class="active">
  						<c:set var="liClass" value="${'active'}"/>
  					</c:when>
  					<c:otherwise>
  						<li>
  					</c:otherwise>
  				</c:choose>
  				<a data-toggle="tab" href="#Consent">
  				<h5 class="m-0 font-weight-bold text-primary">Building <br> Consent</h5></a></li>
  			</c:if>
  			
  			<c:if test="${not empty asbestosTab.tabDsp}">
  			  	<c:choose>
  					<c:when test="${empty liClass}">
  						<li class="active">
  						<c:set var="liClass" value="${'active'}"/>
  					</c:when>
  					<c:otherwise>
  						<li>
  					</c:otherwise>
  				</c:choose>
  				<a data-toggle="tab" href="#Asbestos">
  				<h5 class="m-0 font-weight-bold text-primary">Asbestos <br><br></h5></a></li> 	
  			</c:if>
  			
  			<c:if test="${not empty electricalTab.tabDsp}">
  			  	<c:choose>
  					<c:when test="${empty liClass}">
  						<li class="active">
  						<c:set var="liClass" value="${'active'}"/>
  					</c:when>
  					<c:otherwise>
  						<li>
  					</c:otherwise>
  				</c:choose>
  				<a data-toggle="tab" href="#Electrical">
  				<h5 class="m-0 font-weight-bold text-primary">Electrical <br><br></h5></a></li>	
  			</c:if>
  			
  			<c:if test="${not empty gasTab.tabDsp}">
  			  	<c:choose>
  					<c:when test="${empty liClass}">
  						<li class="active">
  						<c:set var="liClass" value="${'active'}"/>
  					</c:when>
  					<c:otherwise>
  						<li>
  					</c:otherwise>
  				</c:choose>
  				<a data-toggle="tab" href="#Gas">
  				<h5 class="m-0 font-weight-bold text-primary">Gas<br><br></h5></a></li>	
  			</c:if>
  			
  			<c:if test="${not empty fireTab.tabDsp}">
  			  	<c:choose>
  					<c:when test="${empty liClass}">
  						<li class="active">
  						<c:set var="liClass" value="${'active'}"/>
  					</c:when>
  					<c:otherwise>
  						<li>
  					</c:otherwise>
  				</c:choose>
  				<a data-toggle="tab" href="#Fire">
  				<h5 class="m-0 font-weight-bold text-primary">Fire<br><br></h5></a></li>	
  			</c:if>
  			
  			<c:if test="${not empty hazSubsTab.tabDsp}">
  			  	<c:choose>
  					<c:when test="${empty liClass}">
  						<li class="active">
  						<c:set var="liClass" value="${'active'}"/>
  					</c:when>
  					<c:otherwise>
  						<li>
  					</c:otherwise>
  				</c:choose>
  				<a data-toggle="tab" href="#HazSubs">
  				<h5 class="m-0 font-weight-bold text-primary">Hazardous <br> Substances</h5></a></li>
  			</c:if>
  			
  			<c:if test="${not empty hazRegTab.tabDsp}">
  			  	<c:choose>
  					<c:when test="${empty liClass}">
  						<li class="active">
  						<c:set var="liClass" value="${'active'}"/>
  					</c:when>
  					<c:otherwise>
  						<li>
  					</c:otherwise>
  				</c:choose>
  				<a data-toggle="tab" href="#HazReg">
  				<h5 class="m-0 font-weight-bold text-primary">Hazard <br> Register</h5></a></li>
  			</c:if>
  			
  			<c:if test="${not empty seismicTab.tabDsp}">
  				<c:choose>
  					<c:when test="${empty liClass}">
  						<li class="active">
  						<c:set var="liClass" value="${'active'}"/>
  					</c:when>
  					<c:otherwise>
  						<li>
  					</c:otherwise>
  				</c:choose>
  				<a data-toggle="tab" href="#Seismic">
  				<h5 class="m-0 font-weight-bold text-primary">Seismic <br> Resilience</h5></a></li>
  			</c:if>
  			
  			<c:if test="${not empty resourceConsentTab.tabDsp}">
  				<c:choose>
  					<c:when test="${empty liClass}">
  						<li class="active">
  						<c:set var="liClass" value="${'active'}"/>
  					</c:when>
  					<c:otherwise>
  						<li>
  					</c:otherwise>
  				</c:choose>
  				<a data-toggle="tab" href="#ResourceConsent">
  				<h5 class="m-0 font-weight-bold text-primary">Resource <br> Consents</h5></a></li>
  			</c:if>
  			
  			<c:if test="${not empty comInsTab.tabDsp}">
  				<c:choose>
  					<c:when test="${empty liClass}">
  						<li class="active">
  						<c:set var="liClass" value="${'active'}"/>
  					</c:when>
  					<c:otherwise>
  						<li>
  					</c:otherwise>
  				</c:choose>
  				<a data-toggle="tab" href="#ComIns">
  				<h5 class="m-0 font-weight-bold text-primary">Compliance <br> Inspection</h5></a></li>	
  			</c:if>	
		</ul>