using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Threading.Tasks;
using ADB_Project.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Newtonsoft.Json;
using WebAppADB.Models;

namespace ADB_Project.Controllers
{
    [Route("location")]
    [ApiController]
    public class LocationController : ControllerBase
    {
        public readonly IConfiguration _configuration;

        public LocationController(IConfiguration configuration)
        {
            _configuration = configuration; // used to provide access to configuration settings such as app settings (connection strings)
        }

        // Insert new records into the database table
        [HttpPost("createlocation")]
        public async Task<IActionResult> CreateLocation(CreateLocation createLocation)
        {
            try
            {
                using (SqlConnection con = new SqlConnection(_configuration.GetConnectionString("LocationConnection")))
                {
                    await con.OpenAsync();

                    string sqlQuery = @"INSERT INTO Production.Location (Name, CostRate, Availability, ModifiedDate)
                                VALUES (@Name, @CostRate, @Availability, @ModifiedDate)";

                    using (SqlCommand cmd = new SqlCommand(sqlQuery, con))
                    {
                        cmd.Parameters.AddWithValue("@Name", createLocation.Name);
                        cmd.Parameters.AddWithValue("@CostRate", createLocation.CostRate);
                        cmd.Parameters.AddWithValue("@Availability", createLocation.Availability);
                        cmd.Parameters.AddWithValue("@ModifiedDate", DateTime.Now);

                        int rowsAffected = await cmd.ExecuteNonQueryAsync();

                        if (rowsAffected > 0)
                        {
                            var response = new
                            {
                                Status = 200,
                                Message = "Location created successfully"
                            };
                            return Ok(response);
                        }
                        else
                        {
                            return BadRequest();
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                var response = new
                {
                    Status = 500,
                    Message = ex.Message
                };

                return StatusCode(500, response);
            }
        }



        // Retrieve records from the database table (using stored procedure)
        [HttpGet("getlocations")]
        public async Task<IActionResult> GetLocationsAsync()
        {
            try
            {
                using (SqlConnection con = new SqlConnection(_configuration.GetConnectionString("LocationConnection")))
                {
                    await con.OpenAsync();

                    using (SqlCommand cmd = new SqlCommand("GetLocations", con))
                    {
                        cmd.CommandType = CommandType.StoredProcedure;

                        using (SqlDataAdapter da = new SqlDataAdapter(cmd))
                        {
                            DataTable dt = new DataTable();
                            await Task.Run(() => da.Fill(dt)); // Perform Fill operation asynchronously

                            if (dt.Rows.Count > 0)
                            {
                                List<Location> locationList = new List<Location>();

                                foreach (DataRow row in dt.Rows)
                                {
                                    Location location = new Location
                                    {
                                        LocationID = Convert.ToInt32(row["LocationID"]),
                                        Name = Convert.ToString(row["Name"]),
                                        CostRate = Convert.ToDouble(row["CostRate"]),
                                        Availability = Convert.ToDouble(row["Availability"]),
                                        ModifiedDate = Convert.ToDateTime(row["ModifiedDate"])
                                    };

                                    locationList.Add(location);
                                }
                                var response = new
                                {
                                    Status = 200,
                                    Data = locationList
                                };

                                return Ok(response);
                            }
                            else
                            {
                                return NotFound();
                            }
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                var response = new
                {
                    Status = 500,
                    Message = ex.Message
                };

                return StatusCode(500, response);
            }
        }

        // get location by Id
        [HttpGet("getlocationbyid/{id}")]
        public async Task<IActionResult> GetLocationById(int id)
        {
            try
            {
                using (SqlConnection con = new SqlConnection(_configuration.GetConnectionString("LocationConnection")))
                {
                    await con.OpenAsync();
                    string sqlQuery = "SELECT * FROM production.location WHERE LocationID = @id";

                    using (SqlCommand cmd = new SqlCommand(sqlQuery, con))
                    {
                        cmd.Parameters.AddWithValue("@id", id);

                        using (SqlDataReader reader = await cmd.ExecuteReaderAsync())
                        {
                            if (await reader.ReadAsync())
                            {
                                Location location = new Location
                                {
                                    LocationID = Convert.ToInt32(reader["LocationID"]),
                                    Name = Convert.ToString(reader["Name"]),
                                    CostRate = Convert.ToDouble(reader["CostRate"]),
                                    Availability = Convert.ToDouble(reader["Availability"]),
                                    ModifiedDate = Convert.ToDateTime(reader["ModifiedDate"])
                                };
                                var response = new
                                {
                                    Status = 200,
                                    Data = location
                                };
                                return Ok(response);
                            }
                            else
                            {
                                return NotFound();
                            }
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                var response = new
                {
                    Status = 500,
                    Message = ex.Message
                };

                return StatusCode(500, response);
            }
        }


        // Modify existing records in the database table
        [HttpPut("updatelocation")]
        public async Task<IActionResult> UpdateLocation(UpdateLocation updateLocation)
        {
            try
            {
                using (SqlConnection con = new SqlConnection(_configuration.GetConnectionString("LocationConnection")))
                {
                    await con.OpenAsync();
                    string sqlQuery = @"UPDATE Production.Location 
                                SET Name = @Name, CostRate = @CostRate, Availability = @Availability, ModifiedDate = @ModifiedDate
                                WHERE LocationID = @LocationID";
                    using (SqlCommand cmd = new SqlCommand(sqlQuery, con))
                    {
                        cmd.Parameters.AddWithValue("@LocationID", updateLocation.LocationID);
                        cmd.Parameters.AddWithValue("@Name", updateLocation.Name);
                        cmd.Parameters.AddWithValue("@CostRate", updateLocation.CostRate);
                        cmd.Parameters.AddWithValue("@Availability", updateLocation.Availability);
                        cmd.Parameters.AddWithValue("@ModifiedDate", DateTime.Now);

                        int rowsAffected = await cmd.ExecuteNonQueryAsync();

                        if (rowsAffected > 0)
                        {
                            var response = new
                            {
                                Status = 200,
                                Message = "Location updated successfully"
                            };
                            return Ok(response);
                        }
                        else
                        {
                            return BadRequest();
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                var response = new
                {
                    Status = 500,
                    Message = ex.Message
                };

                return StatusCode(500, response);
            }
        }

        //  Remove records from the database table
        [HttpDelete("deletelocation/{id}")]
        public async Task<IActionResult> DeleteLocation(int id)
        {
            try
            {
                using (SqlConnection con = new SqlConnection(_configuration.GetConnectionString("LocationConnection")))
                {
                    await con.OpenAsync();
                    string sqlQuery = "DELETE FROM Production.Location WHERE LocationID = @id";

                    using (SqlCommand cmd = new SqlCommand(sqlQuery, con))
                    {
                        cmd.Parameters.AddWithValue("@id", id);

                        int rowsAffected = await cmd.ExecuteNonQueryAsync();

                        if (rowsAffected > 0)
                        {
                            var response = new
                            {
                                Status = 200,
                                Message = "Location deleted successfully"
                            };
                            return Ok(response);
                        }
                        else
                        {
                            return NotFound();
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                var response = new
                {
                    Status = 500,
                    Message = ex.Message
                };

                return StatusCode(500, response);
            }
        }


    }
}